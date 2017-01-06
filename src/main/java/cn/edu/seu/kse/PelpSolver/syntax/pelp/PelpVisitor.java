// Generated from Pelp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.PelpSolver.syntax.pelp;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PelpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PelpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PelpParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(PelpParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(PelpParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(PelpParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(PelpParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PelpParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(PelpParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#objective_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjective_literal(PelpParser.Objective_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#subjective_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubjective_literal(PelpParser.Subjective_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#rule_head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_head(PelpParser.Rule_headContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#rule_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_body(PelpParser.Rule_bodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fact_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact_rule(PelpParser.Fact_ruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constrain_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrain_rule(PelpParser.Constrain_ruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normal_rule}
	 * labeled alternative in {@link PelpParser#hard_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_rule(PelpParser.Normal_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#soft_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoft_rule(PelpParser.Soft_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PelpParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PelpParser.ProgramContext ctx);
}