package cn.edu.seu.kse.PelpSolver.syntax.asp;

import cn.edu.seu.kse.PelpSolver.model.asp.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ASP语法解析的Visitor实现类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspVisitorImpl extends AspBaseVisitor {
    @Override
    public Object visitInteger(AspParser.IntegerContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitString(AspParser.StringContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitPredicate(AspParser.PredicateContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitVar(AspParser.VarContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitConst_param(AspParser.Const_paramContext ctx) {
        return new AspParam(AspParam.CONSTANT, ctx.getText());
    }

    @Override
    public Object visitVar_param(AspParser.Var_paramContext ctx) {
        return new AspParam(AspParam.VARIABLE, ctx.getText());
    }

    @Override
    public Object visitLiteral(AspParser.LiteralContext ctx) {
        int nafCount = ctx.NAF().size();
        boolean isNegation = ctx.MINUS() != null;
        String predicate = ctx.predicate().getText();
        List<AspParam> params = new ArrayList<>();
        ctx.param().forEach(paramContext -> params.add((AspParam) visit(paramContext)));

        return new AspLiteral(nafCount, isNegation, predicate, params);
    }

    @Override
    public Object visitRule_head(AspParser.Rule_headContext ctx) {
        List<AspLiteral> literals = new ArrayList<>();
        ctx.literal().forEach(literalContext -> literals.add((AspLiteral) visit(literalContext)));
        return literals;
    }

    @Override
    public Object visitRule_body(AspParser.Rule_bodyContext ctx) {
        List<AspLiteral> literals = new ArrayList<>();
        ctx.literal().forEach(literalContext -> literals.add((AspLiteral) visit(literalContext)));
        return literals;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitFact_rule(AspParser.Fact_ruleContext ctx) {
        AspRule rule = new AspRule();
        rule.setHead((List<AspLiteral>)visit(ctx.rule_head()));
        return rule;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitConstrain_rule(AspParser.Constrain_ruleContext ctx) {
        AspRule rule = new AspRule();
        rule.setBody((List<AspLiteral>) visit(ctx.rule_body()));
        return rule;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitNormal_rule(AspParser.Normal_ruleContext ctx) {
        List<AspLiteral> head = (List<AspLiteral>) visit(ctx.rule_head());
        List<AspLiteral> body = (List<AspLiteral>) visit(ctx.rule_body());
        return new AspRule(head, body);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitSoft_constrain(AspParser.Soft_constrainContext ctx) {
        List<AspLiteral> body = (List<AspLiteral>) visit(ctx.rule_body());
        int weight = Integer.parseInt(ctx.integer(0).getText());
        int level = ctx.integer().size() == 2 ? Integer.parseInt(ctx.integer(1).getText()) : 0;

        List<AspParam> params = new ArrayList<>();
        ctx.param().forEach(paramContext -> params.add((AspParam) visit(paramContext)));

        return new AspRule(body, weight, level, params);
    }

    @Override
    public Object visitProgram(AspParser.ProgramContext ctx) {
        List<AspRule> rules = new ArrayList<>();
        ctx.reasoning_rule().forEach(ruleContext -> rules.add((AspRule) visit(ruleContext)));

        return new AspProgram(rules);
    }

    @Override
    public Object visitAnswer_set(AspParser.Answer_setContext ctx) {
        Set<AspLiteral> answerSet = new HashSet<>();
        ctx.literal().forEach(literalContext -> answerSet.add((AspLiteral) visit(literalContext)));

        return new AnswerSet(answerSet);
    }
}
