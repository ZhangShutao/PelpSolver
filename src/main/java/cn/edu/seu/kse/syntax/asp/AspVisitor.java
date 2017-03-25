// Generated from Asp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.syntax.asp;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AspParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AspVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AspParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(AspParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(AspParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(AspParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(AspParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code const_param}
	 * labeled alternative in {@link AspParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_param(AspParser.Const_paramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_param}
	 * labeled alternative in {@link AspParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_param(AspParser.Var_paramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#compare_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_operator(AspParser.Compare_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(AspParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(AspParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#rule_head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_head(AspParser.Rule_headContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#rule_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_body(AspParser.Rule_bodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fact_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact_rule(AspParser.Fact_ruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constrain_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrain_rule(AspParser.Constrain_ruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normal_rule}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_rule(AspParser.Normal_ruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code soft_constrain}
	 * labeled alternative in {@link AspParser#reasoning_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoft_constrain(AspParser.Soft_constrainContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(AspParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AspParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer_set(AspParser.Answer_setContext ctx);
}