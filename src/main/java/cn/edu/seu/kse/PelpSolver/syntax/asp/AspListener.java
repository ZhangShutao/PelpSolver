// Generated from Asp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.PelpSolver.syntax.asp;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AspParser}.
 */
public interface AspListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AspParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(AspParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(AspParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(AspParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(AspParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(AspParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(AspParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(AspParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(AspParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code const_param}
	 * labeled alternative in {@link AspParser#param}.
	 * @param ctx the parse tree
	 */
	void enterConst_param(AspParser.Const_paramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code const_param}
	 * labeled alternative in {@link AspParser#param}.
	 * @param ctx the parse tree
	 */
	void exitConst_param(AspParser.Const_paramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_param}
	 * labeled alternative in {@link AspParser#param}.
	 * @param ctx the parse tree
	 */
	void enterVar_param(AspParser.Var_paramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_param}
	 * labeled alternative in {@link AspParser#param}.
	 * @param ctx the parse tree
	 */
	void exitVar_param(AspParser.Var_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(AspParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(AspParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#rule_head}.
	 * @param ctx the parse tree
	 */
	void enterRule_head(AspParser.Rule_headContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#rule_head}.
	 * @param ctx the parse tree
	 */
	void exitRule_head(AspParser.Rule_headContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#rule_body}.
	 * @param ctx the parse tree
	 */
	void enterRule_body(AspParser.Rule_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#rule_body}.
	 * @param ctx the parse tree
	 */
	void exitRule_body(AspParser.Rule_bodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fact_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void enterFact_rule(AspParser.Fact_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fact_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void exitFact_rule(AspParser.Fact_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constrain_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void enterConstrain_rule(AspParser.Constrain_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constrain_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void exitConstrain_rule(AspParser.Constrain_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normal_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void enterNormal_rule(AspParser.Normal_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normal_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void exitNormal_rule(AspParser.Normal_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code soft_constrain}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void enterSoft_constrain(AspParser.Soft_constrainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code soft_constrain}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 */
	void exitSoft_constrain(AspParser.Soft_constrainContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AspParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AspParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AspParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void enterAnswer_set(AspParser.Answer_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link AspParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void exitAnswer_set(AspParser.Answer_setContext ctx);
}