package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.translate.ProgramTranslator;
import cn.edu.seu.kse.util.Logger;

import java.util.*;

/**
 * 将一个包含软规则的PELP语法单元翻译成不包含软规则的语法单元。由于翻译中引入了以下划线开头的谓词，故所得的程序不符合Pelp程序的语法
 * Created by 张舒韬 on 2017/1/17.
 */
public class SoftRuleReducer implements ProgramTranslator {
    private Logger logger = new Logger(SoftRuleReducer.class);

    private Logger getLogger() {
        return logger;
    }

    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) {
        Set<ObjectModel> objectModelSet = new HashSet<>();
        if (objectModel instanceof PelpProgram) {
            objectModelSet.add(translateProgram(objectModel));
        } else if (objectModel instanceof PelpRule && ((PelpRule) objectModel).isSoft()) {
            objectModelSet.addAll(translateSoftRule((PelpRule) objectModel));
        } else {
            objectModelSet.add(objectModel);
        }
        return objectModelSet;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) {
        getLogger().debug("translating pelp program, reducing soft rules...\n{}", program.toString());
        if (program instanceof PelpProgram) {
            PelpProgram originProgram = (PelpProgram) program;

            List<PelpRule> rules = new ArrayList<>();
            rules.addAll(generateHerbrandDeclare(originProgram));

            originProgram.getRules().forEach(rule ->
                translate(rule).forEach(translatedRule ->
                    rules.add((PelpRule) translatedRule)
                )
            );

            PelpProgram result = new PelpProgram(rules);
            getLogger().debug("soft rules reducing finished:\n{}.", result);
            return result;
        } else {
            return null;
        }
    }

    private Set<PelpRule> translateSoftRule(PelpRule rule) {
        Set<PelpRule> ruleSet = new HashSet<>();

        ruleSet.add(generateSelectOptionRule(rule));
        ruleSet.addAll(generateSelectedResultRule(rule));
        ruleSet.addAll(generateHeadRules(rule));
        ruleSet.add(generateBodyRule(rule));
        ruleSet.add(generateHeadSatisfyRule(rule));
        ruleSet.add(generateBodySatisfyRule(rule));
        ruleSet.add(generateUnselectedConstrain(rule));
        ruleSet.add(generateWeightRule(rule));

        return ruleSet;
    }

    /**
     * 生成用于标识实例化规则的参数列表，包括规则的id和规则中所有的变量
     * @param rule 待处理的规则
     * @return 参数列表
     */
    private List<PelpParam> generateGroundedRuleIdentifyParams(PelpRule rule) {
        Set<PelpParam> variableSet = rule.getVariableSet();

        List<PelpParam> idTerms = new ArrayList<>();
        idTerms.add(new PelpParam(PelpParam.CONSTANT, rule.getId()));
        idTerms.addAll(variableSet);
        return idTerms;
    }

    private PelpObjectiveLiteral generateRuleSelectedLiteral(PelpRule rule) {
        List<PelpParam> selectTerms = generateGroundedRuleIdentifyParams(rule);
        return new PelpObjectiveLiteral(false, false, "_select", selectTerms);
    }

    private PelpObjectiveLiteral generateRuleNotSelectedLiteral(PelpRule rule) {
        List<PelpParam> selectTerms = generateGroundedRuleIdentifyParams(rule);
        return new PelpObjectiveLiteral(true, false, "_select", selectTerms);
    }

    private PelpObjectiveLiteral generateRuleSatisfiedLiteral(PelpRule rule) {
        Set<PelpParam> variableSet = rule.getVariableSet();

        List<PelpParam> selectTerms = new ArrayList<>();
        selectTerms.add(new PelpParam(PelpParam.CONSTANT, rule.getId()));
        selectTerms.addAll(variableSet);
        return new PelpObjectiveLiteral(false, false, "_sat", selectTerms);
    }

    /**
     * 对于Pelp程序中的一个实例项（谓词、整数、字符串常量），生成对应的Herbrand原子声明
     * @param groundedTerm Pelp项
     * @return 如果输入的项是实例项，返回对应的事实规则的Herbrand声明；如果不是，返回null
     */
    private PelpRule generateHerbrandDeclare(PelpParam groundedTerm) {
        if (groundedTerm.getType() != PelpParam.CONSTANT) {
            return null;
        } else {
            List<PelpParam> paramList = new ArrayList<>();
            paramList.add(groundedTerm);
            PelpObjectiveLiteral literal = new PelpObjectiveLiteral(false, false, "_herbrand", paramList);

            List<PelpObjectiveLiteral> head = new ArrayList<>();
            head.add(literal);

            return new PelpRule(head, new ArrayList<>(), null);
        }
    }

    /**
     * 生成Pelp程序中实例项对应的Herbrand原子声明。例如，对 student(jo)中的常量，有Herbrand域声明 _herbrand(jo).
     * @param originProgram Pelp程序
     * @return 事实规则形式的原子声明
     */
    private List<PelpRule> generateHerbrandDeclare(PelpProgram originProgram) {
        Set<PelpParam> groundedTerms = originProgram.getHerbrandUniverse();

        List<PelpRule> herbrandDeclares = new ArrayList<>();
        groundedTerms.forEach(term -> {
            PelpRule declare = generateHerbrandDeclare(term);
            if (null != declare) {
                herbrandDeclares.add(declare);
            }
        });
        return herbrandDeclares;
    }
    /**
     * 生成软规则在MLN子程序中的选用情况选择规则，用于在规则体部被满足时生成该规则被选用与不被选用两个解空间。
     * 例如，对规则feelGood(X) :- rest(X). [2]，有选用规则  _select(_r0,X) | not _select(_r0,X) :- rest(X).
     * @param rule 软规则
     * @return 软规则选用规则
     */
    private PelpRule generateSelectOptionRule(PelpRule rule) {
        PelpObjectiveLiteral selectLiteral = generateRuleSelectedLiteral(rule);
        PelpObjectiveLiteral notSelectLiteral = generateRuleNotSelectedLiteral(rule);

        List<PelpLiteral> herbrandBody = new ArrayList<>();
        selectLiteral.getVariableSet().forEach(variable ->
            herbrandBody.add(new PelpObjectiveLiteral(false, false, "_herbrand", Collections.singletonList(variable)))
        );

        return new PelpRule(Arrays.asList(selectLiteral, notSelectLiteral), herbrandBody, null);
    }

    /**
     * 当前规则被选用且体部被满足，则首部成立。
     * @param rule 软规则
     * @return 软规则被选用时的规则
     */
    private Set<PelpRule> generateSelectedResultRule(PelpRule rule) {
        List<PelpLiteral> selectedBody = new ArrayList<>();
        selectedBody.add(generateRuleSelectedLiteral(rule));
        selectedBody.addAll(rule.getBody());

        Set<PelpRule> resultRules = new HashSet<>();
        rule.getHead().forEach(literal -> {
            PelpRule resultRule = new PelpRule(Collections.singletonList(literal), selectedBody, null);
            resultRules.add(resultRule);
        });
        return resultRules;
    }

    private Set<PelpRule> generateHeadRules(PelpRule rule) {
        Set<PelpRule> headRules = new HashSet<>();
        PelpObjectiveLiteral headLiteral = new PelpObjectiveLiteral(false, false, "_head", generateGroundedRuleIdentifyParams(rule));
        List<PelpObjectiveLiteral> headList = Collections.singletonList(headLiteral);

        rule.getHead().forEach(head -> {
            List<PelpLiteral> bodyList = Collections.singletonList(head);
            headRules.add(new PelpRule(headList, bodyList, null));
        });
        return headRules;
    }

    private PelpRule generateBodyRule(PelpRule rule) {
        PelpObjectiveLiteral bodyLiteral = new PelpObjectiveLiteral(false, false, "_body", generateGroundedRuleIdentifyParams(rule));
        return new PelpRule(Collections.singletonList(bodyLiteral), rule.getBody(), null);
    }

    private PelpRule generateHeadSatisfyRule(PelpRule rule) {
        PelpObjectiveLiteral satisfy = new PelpObjectiveLiteral(false, false, "_sat", generateGroundedRuleIdentifyParams(rule));
        PelpObjectiveLiteral head = new PelpObjectiveLiteral(false, false, "_head", generateGroundedRuleIdentifyParams(rule));
        return new PelpRule(Collections.singletonList(satisfy), Collections.singletonList(head), null);
    }

    private PelpRule generateBodySatisfyRule(PelpRule rule) {
        PelpObjectiveLiteral satisfy = new PelpObjectiveLiteral(false, false, "_sat", generateGroundedRuleIdentifyParams(rule));
        List<PelpLiteral> bodyList = new ArrayList<>();
        bodyList.add(new PelpObjectiveLiteral(true, false, "_body", generateGroundedRuleIdentifyParams(rule)));
        satisfy.getVariableSet().forEach(variable ->
            bodyList.add(new PelpObjectiveLiteral(false, false, "_herbrand", Collections.singletonList(variable)))
        );
        return new PelpRule(Collections.singletonList(satisfy), bodyList, null);
    }

    private PelpRule generateUnselectedConstrain(PelpRule rule) {
        List<PelpLiteral> constrain = new ArrayList<>();
        constrain.add(generateRuleNotSelectedLiteral(rule));
        constrain.add(generateRuleSatisfiedLiteral(rule));
        return new PelpRule(new ArrayList<>(), constrain, null);
    }

    private PelpRule generateWeightRule(PelpRule rule) {
        PelpObjectiveLiteral satisfy = new PelpObjectiveLiteral(false, false, "_sat", generateGroundedRuleIdentifyParams(rule));
        return new PelpRule(new ArrayList<>(), Collections.singletonList(satisfy), rule.getWeight());
    }
}
