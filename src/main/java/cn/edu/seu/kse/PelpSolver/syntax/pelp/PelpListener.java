// Generated from Pelp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.PelpSolver.syntax.pelp;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PelpParser}.
 */
public interface PelpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PelpParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(PelpParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(PelpParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(PelpParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(PelpParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(PelpParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(PelpParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(PelpParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(PelpParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(PelpParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(PelpParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(PelpParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(PelpParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#objective_literal}.
	 * @param ctx the parse tree
	 */
	void enterObjective_literal(PelpParser.Objective_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#objective_literal}.
	 * @param ctx the parse tree
	 */
	void exitObjective_literal(PelpParser.Objective_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#subjective_literal}.
	 * @param ctx the parse tree
	 */
	void enterSubjective_literal(PelpParser.Subjective_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#subjective_literal}.
	 * @param ctx the parse tree
	 */
	void exitSubjective_literal(PelpParser.Subjective_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#rule_head}.
	 * @param ctx the parse tree
	 */
	void enterRule_head(PelpParser.Rule_headContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#rule_head}.
	 * @param ctx the parse tree
	 */
	void exitRule_head(PelpParser.Rule_headContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#rule_body}.
	 * @param ctx the parse tree
	 */
	void enterRule_body(PelpParser.Rule_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#rule_body}.
	 * @param ctx the parse tree
	 */
	void exitRule_body(PelpParser.Rule_bodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fact_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 */
	void enterFact_rule(PelpParser.Fact_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fact_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 */
	void exitFact_rule(PelpParser.Fact_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constrain_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 */
	void enterConstrain_rule(PelpParser.Constrain_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constrain_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 */
	void exitConstrain_rule(PelpParser.Constrain_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normal_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 */
	void enterNormal_rule(PelpParser.Normal_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normal_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 */
	void exitNormal_rule(PelpParser.Normal_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#soft_rule}.
	 * @param ctx the parse tree
	 */
	void enterSoft_rule(PelpParser.Soft_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#soft_rule}.
	 * @param ctx the parse tree
	 */
	void exitSoft_rule(PelpParser.Soft_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PelpParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PelpParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PelpParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PelpParser.ProgramContext ctx);
}