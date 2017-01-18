package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.pelp.PelpObjectiveLiteral;
import cn.edu.seu.kse.model.pelp.PelpParam;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.model.pelp.PelpRule;
import cn.edu.seu.kse.translate.ModelTranslator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 将一个包含软规则的PELP语法单元翻译成不包含软规则的语法单元。由于翻译中引入了以下划线开头的谓词，故所得的程序不符合Pelp程序的语法
 * Created by 张舒韬 on 2017/1/17.
 */
public class SoftRuleReducer implements ModelTranslator {
    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) {

        return null;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) {
        if (program instanceof PelpProgram) {
            PelpProgram originProgram = (PelpProgram) program;

            List<PelpRule> rules = new ArrayList<>();

            rules.addAll(generateHerbrandDeclare(originProgram));

            originProgram.getRules().forEach(rule -> {
                if (!rule.isSoft()) {
                    rules.add(rule);
                } else {
                    rules.addAll(translateSoftRule(rule));
                }
            });

            return new PelpProgram(rules);
        } else {
            return null;
        }
    }

    public Set<PelpRule> translateSoftRule(PelpRule rule) {
        Set<PelpRule> ruleSet = new HashSet<>();
        return ruleSet;
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
     * 生成Pelp程序中实例项对应的Herbrand原子声明
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
}
