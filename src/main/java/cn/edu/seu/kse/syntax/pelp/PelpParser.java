// Generated from Pelp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.syntax.pelp;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PelpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, LESS=7, 
		GREATER=8, EQUAL=9, NOTEQUAL=10, LESSEQ=11, GREATEREQ=12, COMMA=13, DOT=14, 
		VBAR=15, COLON=16, MINUS=17, NAF=18, IF=19, KNOW=20, PR_GREATER=21, DECIMAL=22, 
		POSITIVE_INT=23, ZERO=24, STRING=25, PREDICATE=26, VAR=27, WS=28, LINE_COMMENT=29;
	public static final int
		RULE_integer = 0, RULE_decimal = 1, RULE_string = 2, RULE_predicate = 3, 
		RULE_var = 4, RULE_param = 5, RULE_compare_operator = 6, RULE_relation = 7, 
		RULE_objective_literal = 8, RULE_subjective_literal = 9, RULE_prob_relation = 10, 
		RULE_rule_head = 11, RULE_rule_body = 12, RULE_hard_rule = 13, RULE_soft_rule = 14, 
		RULE_program = 15;
	public static final String[] ruleNames = {
		"integer", "decimal", "string", "predicate", "var", "param", "compare_operator", 
		"relation", "objective_literal", "subjective_literal", "prob_relation", 
		"rule_head", "rule_body", "hard_rule", "soft_rule", "program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'", "'='", "'!='", 
		"'<='", "'>='", "','", "'.'", "'|'", "':'", "'-'", "'not'", "':-'", "'K'", 
		"'#PL'", null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"LESS", "GREATER", "EQUAL", "NOTEQUAL", "LESSEQ", "GREATEREQ", "COMMA", 
		"DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "KNOW", "PR_GREATER", "DECIMAL", 
		"POSITIVE_INT", "ZERO", "STRING", "PREDICATE", "VAR", "WS", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pelp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PelpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode POSITIVE_INT() { return getToken(PelpParser.POSITIVE_INT, 0); }
		public TerminalNode ZERO() { return getToken(PelpParser.ZERO, 0); }
		public TerminalNode MINUS() { return getToken(PelpParser.MINUS, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(32);
				match(MINUS);
				}
			}

			setState(35);
			_la = _input.LA(1);
			if ( !(_la==POSITIVE_INT || _la==ZERO) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecimalContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(PelpParser.DECIMAL, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public DecimalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalContext decimal() throws RecognitionException {
		DecimalContext _localctx = new DecimalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decimal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			switch (_input.LA(1)) {
			case DECIMAL:
				{
				setState(37);
				match(DECIMAL);
				}
				break;
			case MINUS:
			case POSITIVE_INT:
			case ZERO:
				{
				setState(38);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PelpParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode PREDICATE() { return getToken(PelpParser.PREDICATE, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(PREDICATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(PelpParser.VAR, 0); }
		public TerminalNode KNOW() { return getToken(PelpParser.KNOW, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !(_la==KNOW || _la==VAR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Var_paramContext extends ParamContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public Var_paramContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterVar_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitVar_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitVar_param(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Const_paramContext extends ParamContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Const_paramContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterConst_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitConst_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitConst_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			setState(53);
			switch (_input.LA(1)) {
			case MINUS:
			case POSITIVE_INT:
			case ZERO:
			case STRING:
			case PREDICATE:
				_localctx = new Const_paramContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				switch (_input.LA(1)) {
				case MINUS:
				case POSITIVE_INT:
				case ZERO:
					{
					setState(47);
					integer();
					}
					break;
				case STRING:
					{
					setState(48);
					string();
					}
					break;
				case PREDICATE:
					{
					setState(49);
					predicate();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case KNOW:
			case VAR:
				_localctx = new Var_paramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compare_operatorContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(PelpParser.LESS, 0); }
		public TerminalNode LESSEQ() { return getToken(PelpParser.LESSEQ, 0); }
		public TerminalNode GREATER() { return getToken(PelpParser.GREATER, 0); }
		public TerminalNode GREATEREQ() { return getToken(PelpParser.GREATEREQ, 0); }
		public TerminalNode EQUAL() { return getToken(PelpParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(PelpParser.NOTEQUAL, 0); }
		public Compare_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterCompare_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitCompare_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitCompare_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_operatorContext compare_operator() throws RecognitionException {
		Compare_operatorContext _localctx = new Compare_operatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compare_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << EQUAL) | (1L << NOTEQUAL) | (1L << LESSEQ) | (1L << GREATEREQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public Compare_operatorContext compare_operator() {
			return getRuleContext(Compare_operatorContext.class,0);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			param();
			setState(58);
			compare_operator();
			setState(59);
			param();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Objective_literalContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public List<TerminalNode> NAF() { return getTokens(PelpParser.NAF); }
		public TerminalNode NAF(int i) {
			return getToken(PelpParser.NAF, i);
		}
		public TerminalNode MINUS() { return getToken(PelpParser.MINUS, 0); }
		public TerminalNode LPAREN() { return getToken(PelpParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PelpParser.RPAREN, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PelpParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PelpParser.COMMA, i);
		}
		public Objective_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objective_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterObjective_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitObjective_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitObjective_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Objective_literalContext objective_literal() throws RecognitionException {
		Objective_literalContext _localctx = new Objective_literalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_objective_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAF) {
				{
				{
				setState(61);
				match(NAF);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(67);
				match(MINUS);
				}
			}

			setState(70);
			predicate();
			setState(83);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(71);
				match(LPAREN);
				setState(80);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << KNOW) | (1L << POSITIVE_INT) | (1L << ZERO) | (1L << STRING) | (1L << PREDICATE) | (1L << VAR))) != 0)) {
					{
					setState(72);
					param();
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(73);
						match(COMMA);
						setState(74);
						param();
						}
						}
						setState(79);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(82);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Subjective_literalContext extends ParserRuleContext {
		public TerminalNode KNOW() { return getToken(PelpParser.KNOW, 0); }
		public List<DecimalContext> decimal() {
			return getRuleContexts(DecimalContext.class);
		}
		public DecimalContext decimal(int i) {
			return getRuleContext(DecimalContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PelpParser.COMMA, 0); }
		public Objective_literalContext objective_literal() {
			return getRuleContext(Objective_literalContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PelpParser.LPAREN, 0); }
		public TerminalNode LSBRACK() { return getToken(PelpParser.LSBRACK, 0); }
		public TerminalNode RPAREN() { return getToken(PelpParser.RPAREN, 0); }
		public TerminalNode RSBRACK() { return getToken(PelpParser.RSBRACK, 0); }
		public Subjective_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subjective_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterSubjective_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitSubjective_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitSubjective_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subjective_literalContext subjective_literal() throws RecognitionException {
		Subjective_literalContext _localctx = new Subjective_literalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subjective_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(KNOW);
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==LPAREN || _la==LSBRACK) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(87);
			decimal();
			setState(88);
			match(COMMA);
			setState(89);
			decimal();
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==RPAREN || _la==RSBRACK) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(91);
			objective_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Prob_relationContext extends ParserRuleContext {
		public TerminalNode PR_GREATER() { return getToken(PelpParser.PR_GREATER, 0); }
		public TerminalNode LPAREN() { return getToken(PelpParser.LPAREN, 0); }
		public List<Objective_literalContext> objective_literal() {
			return getRuleContexts(Objective_literalContext.class);
		}
		public Objective_literalContext objective_literal(int i) {
			return getRuleContext(Objective_literalContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PelpParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PelpParser.RPAREN, 0); }
		public Prob_relationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prob_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterProb_relation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitProb_relation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitProb_relation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prob_relationContext prob_relation() throws RecognitionException {
		Prob_relationContext _localctx = new Prob_relationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_prob_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(PR_GREATER);
			setState(94);
			match(LPAREN);
			setState(95);
			objective_literal();
			setState(96);
			match(COMMA);
			setState(97);
			objective_literal();
			setState(98);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rule_headContext extends ParserRuleContext {
		public List<Objective_literalContext> objective_literal() {
			return getRuleContexts(Objective_literalContext.class);
		}
		public Objective_literalContext objective_literal(int i) {
			return getRuleContext(Objective_literalContext.class,i);
		}
		public List<TerminalNode> VBAR() { return getTokens(PelpParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(PelpParser.VBAR, i);
		}
		public Rule_headContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterRule_head(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitRule_head(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitRule_head(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_headContext rule_head() throws RecognitionException {
		Rule_headContext _localctx = new Rule_headContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rule_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			objective_literal();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(101);
				match(VBAR);
				setState(102);
				objective_literal();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rule_bodyContext extends ParserRuleContext {
		public List<Objective_literalContext> objective_literal() {
			return getRuleContexts(Objective_literalContext.class);
		}
		public Objective_literalContext objective_literal(int i) {
			return getRuleContext(Objective_literalContext.class,i);
		}
		public List<Subjective_literalContext> subjective_literal() {
			return getRuleContexts(Subjective_literalContext.class);
		}
		public Subjective_literalContext subjective_literal(int i) {
			return getRuleContext(Subjective_literalContext.class,i);
		}
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<Prob_relationContext> prob_relation() {
			return getRuleContexts(Prob_relationContext.class);
		}
		public Prob_relationContext prob_relation(int i) {
			return getRuleContext(Prob_relationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PelpParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PelpParser.COMMA, i);
		}
		public Rule_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterRule_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitRule_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitRule_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_bodyContext rule_body() throws RecognitionException {
		Rule_bodyContext _localctx = new Rule_bodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rule_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(108);
				objective_literal();
				}
				break;
			case 2:
				{
				setState(109);
				subjective_literal();
				}
				break;
			case 3:
				{
				setState(110);
				relation();
				}
				break;
			case 4:
				{
				setState(111);
				prob_relation();
				}
				break;
			}
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(114);
				match(COMMA);
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(115);
					objective_literal();
					}
					break;
				case 2:
					{
					setState(116);
					subjective_literal();
					}
					break;
				case 3:
					{
					setState(117);
					relation();
					}
					break;
				case 4:
					{
					setState(118);
					prob_relation();
					}
					break;
				}
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Hard_ruleContext extends ParserRuleContext {
		public Hard_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hard_rule; }
	 
		public Hard_ruleContext() { }
		public void copyFrom(Hard_ruleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Constrain_ruleContext extends Hard_ruleContext {
		public TerminalNode IF() { return getToken(PelpParser.IF, 0); }
		public Rule_bodyContext rule_body() {
			return getRuleContext(Rule_bodyContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PelpParser.DOT, 0); }
		public Constrain_ruleContext(Hard_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterConstrain_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitConstrain_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitConstrain_rule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Normal_ruleContext extends Hard_ruleContext {
		public Rule_headContext rule_head() {
			return getRuleContext(Rule_headContext.class,0);
		}
		public TerminalNode IF() { return getToken(PelpParser.IF, 0); }
		public Rule_bodyContext rule_body() {
			return getRuleContext(Rule_bodyContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PelpParser.DOT, 0); }
		public Normal_ruleContext(Hard_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterNormal_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitNormal_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitNormal_rule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Fact_ruleContext extends Hard_ruleContext {
		public Rule_headContext rule_head() {
			return getRuleContext(Rule_headContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PelpParser.DOT, 0); }
		public Fact_ruleContext(Hard_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterFact_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitFact_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitFact_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Hard_ruleContext hard_rule() throws RecognitionException {
		Hard_ruleContext _localctx = new Hard_ruleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_hard_rule);
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new Fact_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				rule_head();
				setState(127);
				match(DOT);
				}
				break;
			case 2:
				_localctx = new Constrain_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(IF);
				setState(130);
				rule_body();
				setState(131);
				match(DOT);
				}
				break;
			case 3:
				_localctx = new Normal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				rule_head();
				setState(134);
				match(IF);
				setState(135);
				rule_body();
				setState(136);
				match(DOT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Soft_ruleContext extends ParserRuleContext {
		public Hard_ruleContext hard_rule() {
			return getRuleContext(Hard_ruleContext.class,0);
		}
		public TerminalNode LSBRACK() { return getToken(PelpParser.LSBRACK, 0); }
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public TerminalNode RSBRACK() { return getToken(PelpParser.RSBRACK, 0); }
		public Soft_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_soft_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterSoft_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitSoft_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitSoft_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Soft_ruleContext soft_rule() throws RecognitionException {
		Soft_ruleContext _localctx = new Soft_ruleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_soft_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			hard_rule();
			setState(141);
			match(LSBRACK);
			setState(142);
			decimal();
			setState(143);
			match(RSBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<Soft_ruleContext> soft_rule() {
			return getRuleContexts(Soft_ruleContext.class);
		}
		public Soft_ruleContext soft_rule(int i) {
			return getRuleContext(Soft_ruleContext.class,i);
		}
		public List<Hard_ruleContext> hard_rule() {
			return getRuleContexts(Hard_ruleContext.class);
		}
		public Hard_ruleContext hard_rule(int i) {
			return getRuleContext(Hard_ruleContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << IF) | (1L << PREDICATE))) != 0)) {
				{
				setState(147);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(145);
					soft_rule();
					}
					break;
				case 2:
					{
					setState(146);
					hard_rule();
					}
					break;
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u009b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\5\2"+
		"$\n\2\3\2\3\2\3\3\3\3\5\3*\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7"+
		"\65\n\7\3\7\5\78\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\7\nA\n\n\f\n\16\nD\13"+
		"\n\3\n\5\nG\n\n\3\n\3\n\3\n\3\n\3\n\7\nN\n\n\f\n\16\nQ\13\n\5\nS\n\n\3"+
		"\n\5\nV\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\7\rj\n\r\f\r\16\rm\13\r\3\16\3\16\3\16\3\16\5\16"+
		"s\n\16\3\16\3\16\3\16\3\16\3\16\5\16z\n\16\7\16|\n\16\f\16\16\16\177\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u008d"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u0096\n\21\f\21\16\21\u0099"+
		"\13\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\7\3\2\31"+
		"\32\4\2\26\26\35\35\3\2\t\16\4\2\3\3\5\5\4\2\4\4\6\6\u00a0\2#\3\2\2\2"+
		"\4)\3\2\2\2\6+\3\2\2\2\b-\3\2\2\2\n/\3\2\2\2\f\67\3\2\2\2\169\3\2\2\2"+
		"\20;\3\2\2\2\22B\3\2\2\2\24W\3\2\2\2\26_\3\2\2\2\30f\3\2\2\2\32r\3\2\2"+
		"\2\34\u008c\3\2\2\2\36\u008e\3\2\2\2 \u0097\3\2\2\2\"$\7\23\2\2#\"\3\2"+
		"\2\2#$\3\2\2\2$%\3\2\2\2%&\t\2\2\2&\3\3\2\2\2\'*\7\30\2\2(*\5\2\2\2)\'"+
		"\3\2\2\2)(\3\2\2\2*\5\3\2\2\2+,\7\33\2\2,\7\3\2\2\2-.\7\34\2\2.\t\3\2"+
		"\2\2/\60\t\3\2\2\60\13\3\2\2\2\61\65\5\2\2\2\62\65\5\6\4\2\63\65\5\b\5"+
		"\2\64\61\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\658\3\2\2\2\668\5\n\6\2\67"+
		"\64\3\2\2\2\67\66\3\2\2\28\r\3\2\2\29:\t\4\2\2:\17\3\2\2\2;<\5\f\7\2<"+
		"=\5\16\b\2=>\5\f\7\2>\21\3\2\2\2?A\7\24\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2"+
		"\2\2BC\3\2\2\2CF\3\2\2\2DB\3\2\2\2EG\7\23\2\2FE\3\2\2\2FG\3\2\2\2GH\3"+
		"\2\2\2HU\5\b\5\2IR\7\3\2\2JO\5\f\7\2KL\7\17\2\2LN\5\f\7\2MK\3\2\2\2NQ"+
		"\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RJ\3\2\2\2RS\3\2\2\2S"+
		"T\3\2\2\2TV\7\4\2\2UI\3\2\2\2UV\3\2\2\2V\23\3\2\2\2WX\7\26\2\2XY\t\5\2"+
		"\2YZ\5\4\3\2Z[\7\17\2\2[\\\5\4\3\2\\]\t\6\2\2]^\5\22\n\2^\25\3\2\2\2_"+
		"`\7\27\2\2`a\7\3\2\2ab\5\22\n\2bc\7\17\2\2cd\5\22\n\2de\7\4\2\2e\27\3"+
		"\2\2\2fk\5\22\n\2gh\7\21\2\2hj\5\22\n\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2"+
		"kl\3\2\2\2l\31\3\2\2\2mk\3\2\2\2ns\5\22\n\2os\5\24\13\2ps\5\20\t\2qs\5"+
		"\26\f\2rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s}\3\2\2\2ty\7\17\2\2u"+
		"z\5\22\n\2vz\5\24\13\2wz\5\20\t\2xz\5\26\f\2yu\3\2\2\2yv\3\2\2\2yw\3\2"+
		"\2\2yx\3\2\2\2z|\3\2\2\2{t\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\33"+
		"\3\2\2\2\177}\3\2\2\2\u0080\u0081\5\30\r\2\u0081\u0082\7\20\2\2\u0082"+
		"\u008d\3\2\2\2\u0083\u0084\7\25\2\2\u0084\u0085\5\32\16\2\u0085\u0086"+
		"\7\20\2\2\u0086\u008d\3\2\2\2\u0087\u0088\5\30\r\2\u0088\u0089\7\25\2"+
		"\2\u0089\u008a\5\32\16\2\u008a\u008b\7\20\2\2\u008b\u008d\3\2\2\2\u008c"+
		"\u0080\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u0087\3\2\2\2\u008d\35\3\2\2"+
		"\2\u008e\u008f\5\34\17\2\u008f\u0090\7\5\2\2\u0090\u0091\5\4\3\2\u0091"+
		"\u0092\7\6\2\2\u0092\37\3\2\2\2\u0093\u0096\5\36\20\2\u0094\u0096\5\34"+
		"\17\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098!\3\2\2\2\u0099\u0097\3\2\2\2"+
		"\22#)\64\67BFORUkry}\u008c\u0095\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}