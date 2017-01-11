package cn.edu.seu.kse.syntax.pelp;

import cn.edu.seu.kse.model.pelp.*;

import java.util.ArrayList;
import java.util.List;

/**
 * PelpVisitor接口的一种实现，继承自PelpBaseVisitor
 * Created by 张舒韬 on 2017/1/8.
 */
public class PelpVisitorImpl extends PelpBaseVisitor {
    @Override
    public Object visitInteger(PelpParser.IntegerContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitDecimal(PelpParser.DecimalContext ctx) {
        return Double.parseDouble(ctx.getText());
    }

    @Override
    public Object visitString(PelpParser.StringContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitPredicate(PelpParser.PredicateContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitVar(PelpParser.VarContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitConst_param(PelpParser.Const_paramContext ctx) {
        String obj;
        if (ctx.integer() != null) {
            obj = visitInteger(ctx.integer()).toString();
        } else if (ctx.string() != null) {
            obj = visitString(ctx.string()).toString();
        } else {
            obj = visitPredicate(ctx.predicate()).toString();
        }
        return new PelpParam(PelpParam.CONSTANT, obj);
    }

    @Override
    public Object visitVar_param(PelpParser.Var_paramContext ctx) {
        return new PelpParam(PelpParam.VARIABLE, visitVar(ctx.var()).toString());
    }

    @Override
    public Object visitObjective_literal(PelpParser.Objective_literalContext ctx) {
        boolean isNaf = ctx.NAF() != null;
        boolean isNegation = ctx.MINUS() != null;
        String predicate = ctx.predicate().getText();

        List<PelpParam> params = new ArrayList<>();
        ctx.param().forEach(paramContext -> params.add((PelpParam) visit(paramContext)));

        return new PelpObjectiveLiteral(isNaf, isNegation, predicate, params);
    }

    @Override
    public Object visitSubjective_literal(PelpParser.Subjective_literalContext ctx) {
        boolean isLeftClose = ctx.LSBRACK() != null;
        boolean isRightClose = ctx.RSBRACK() != null;
        Double leftBound = (double) visit(ctx.decimal(0));
        Double rightBound = (double) visit(ctx.decimal(1));
        PelpObjectiveLiteral objectiveLiteral = (PelpObjectiveLiteral) visit(ctx.objective_literal());

        return new PelpSubjectiveLiteral(isLeftClose, isRightClose, leftBound, rightBound, objectiveLiteral);
    }

    @Override
    public Object visitRule_head(PelpParser.Rule_headContext ctx) {
        List<PelpObjectiveLiteral> head = new ArrayList<>();
        ctx.objective_literal().forEach(objective_literalContext -> head.add((PelpObjectiveLiteral) visit(objective_literalContext)));
        return head;
    }

    @Override
    public Object visitRule_body(PelpParser.Rule_bodyContext ctx) {
        List<PelpLiteral> body = new ArrayList<>();
        for (int i = 0; i != ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) instanceof PelpParser.Subjective_literalContext || ctx.getChild(i) instanceof PelpParser.Objective_literalContext) {
                body.add((PelpLiteral) visit(ctx.getChild(i)));
            }
        }
        return body;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitFact_rule(PelpParser.Fact_ruleContext ctx) {
        List<PelpObjectiveLiteral> head = (List) visit(ctx.rule_head());

        return new PelpRule(head, new ArrayList<>(), null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitConstrain_rule(PelpParser.Constrain_ruleContext ctx) {
        List<PelpLiteral> body = (List) visit(ctx.rule_body());
        return new PelpRule(new ArrayList<>(), body, null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitNormal_rule(PelpParser.Normal_ruleContext ctx) {
        List<PelpObjectiveLiteral> head = (List) visit(ctx.rule_head());
        List<PelpLiteral> body = (List) visit(ctx.rule_body());
        return new PelpRule(head, body, null);
    }

    @Override
    public Object visitSoft_rule(PelpParser.Soft_ruleContext ctx) {
        PelpRule rule = (PelpRule) visit(ctx.hard_rule());
        rule.setWeight((double) visit(ctx.decimal()));
        return rule;
    }

    @Override
    public Object visitProgram(PelpParser.ProgramContext ctx) {
        List<PelpRule> rules = new ArrayList<>();
        for (int i = 0; i != ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) instanceof PelpParser.Hard_ruleContext || ctx.getChild(i) instanceof  PelpParser.Soft_ruleContext) {
                rules.add((PelpRule) visit(ctx.getChild(i)));
            }
        }
        return new PelpProgram(rules);
    }
}
