// Generated from Asp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.syntax.asp;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AspParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, COMMA=7, 
		DOT=8, VBAR=9, COLON=10, MINUS=11, NAF=12, IF=13, SOFT_IF=14, AT=15, DECIMAL=16, 
		POSITIVE_INT=17, ZERO=18, STRING=19, PREDICATE=20, VAR=21, WS=22, LINE_COMMENT=23;
	public static final int
		RULE_integer = 0, RULE_string = 1, RULE_predicate = 2, RULE_var = 3, RULE_param = 4, 
		RULE_literal = 5, RULE_rule_head = 6, RULE_rule_body = 7, RULE_reasoning_rule = 8, 
		RULE_program = 9, RULE_answer_set = 10;
	public static final String[] ruleNames = {
		"integer", "string", "predicate", "var", "param", "literal", "rule_head", 
		"rule_body", "reasoning_rule", "program", "answer_set"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "'.'", "'|'", "':'", 
		"'-'", "'not'", "':-'", "':~'", "'@'", null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"COMMA", "DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "SOFT_IF", "AT", 
		"DECIMAL", "POSITIVE_INT", "ZERO", "STRING", "PREDICATE", "VAR", "WS", 
		"LINE_COMMENT"
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
	public String getGrammarFileName() { return "Asp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AspParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode POSITIVE_INT() { return getToken(AspParser.POSITIVE_INT, 0); }
		public TerminalNode ZERO() { return getToken(AspParser.ZERO, 0); }
		public TerminalNode MINUS() { return getToken(AspParser.MINUS, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitInteger(this);
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
			setState(23);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(22);
				match(MINUS);
				}
			}

			setState(25);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AspParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
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
		public TerminalNode PREDICATE() { return getToken(AspParser.PREDICATE, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
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
		public TerminalNode VAR() { return getToken(AspParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(VAR);
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
			if ( listener instanceof AspListener ) ((AspListener)listener).enterVar_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitVar_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitVar_param(this);
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
			if ( listener instanceof AspListener ) ((AspListener)listener).enterConst_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitConst_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitConst_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			setState(39);
			switch (_input.LA(1)) {
			case MINUS:
			case POSITIVE_INT:
			case ZERO:
			case STRING:
			case PREDICATE:
				_localctx = new Const_paramContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				switch (_input.LA(1)) {
				case MINUS:
				case POSITIVE_INT:
				case ZERO:
					{
					setState(33);
					integer();
					}
					break;
				case STRING:
					{
					setState(34);
					string();
					}
					break;
				case PREDICATE:
					{
					setState(35);
					predicate();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case VAR:
				_localctx = new Var_paramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
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

	public static class LiteralContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public List<TerminalNode> NAF() { return getTokens(AspParser.NAF); }
		public TerminalNode NAF(int i) {
			return getToken(AspParser.NAF, i);
		}
		public TerminalNode MINUS() { return getToken(AspParser.MINUS, 0); }
		public TerminalNode LPAREN() { return getToken(AspParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AspParser.RPAREN, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AspParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AspParser.COMMA, i);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAF) {
				{
				{
				setState(41);
				match(NAF);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(47);
				match(MINUS);
				}
			}

			setState(50);
			predicate();
			setState(63);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(51);
				match(LPAREN);
				setState(60);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << POSITIVE_INT) | (1L << ZERO) | (1L << STRING) | (1L << PREDICATE) | (1L << VAR))) != 0)) {
					{
					setState(52);
					param();
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(53);
						match(COMMA);
						setState(54);
						param();
						}
						}
						setState(59);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(62);
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

	public static class Rule_headContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<TerminalNode> VBAR() { return getTokens(AspParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(AspParser.VBAR, i);
		}
		public Rule_headContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterRule_head(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitRule_head(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitRule_head(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_headContext rule_head() throws RecognitionException {
		Rule_headContext _localctx = new Rule_headContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rule_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			literal();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(66);
				match(VBAR);
				setState(67);
				literal();
				}
				}
				setState(72);
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
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AspParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AspParser.COMMA, i);
		}
		public Rule_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterRule_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitRule_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitRule_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_bodyContext rule_body() throws RecognitionException {
		Rule_bodyContext _localctx = new Rule_bodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rule_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			literal();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(74);
				match(COMMA);
				setState(75);
				literal();
				}
				}
				setState(80);
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

	public static class Reasoning_ruleContext extends ParserRuleContext {
		public Reasoning_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reasoning_rule; }
	 
		public Reasoning_ruleContext() { }
		public void copyFrom(Reasoning_ruleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Soft_constrainContext extends Reasoning_ruleContext {
		public TerminalNode SOFT_IF() { return getToken(AspParser.SOFT_IF, 0); }
		public Rule_bodyContext rule_body() {
			return getRuleContext(Rule_bodyContext.class,0);
		}
		public TerminalNode DOT() { return getToken(AspParser.DOT, 0); }
		public TerminalNode LSBRACK() { return getToken(AspParser.LSBRACK, 0); }
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode RSBRACK() { return getToken(AspParser.RSBRACK, 0); }
		public TerminalNode AT() { return getToken(AspParser.AT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AspParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AspParser.COMMA, i);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public Soft_constrainContext(Reasoning_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterSoft_constrain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitSoft_constrain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitSoft_constrain(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Constrain_ruleContext extends Reasoning_ruleContext {
		public TerminalNode IF() { return getToken(AspParser.IF, 0); }
		public Rule_bodyContext rule_body() {
			return getRuleContext(Rule_bodyContext.class,0);
		}
		public TerminalNode DOT() { return getToken(AspParser.DOT, 0); }
		public Constrain_ruleContext(Reasoning_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterConstrain_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitConstrain_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitConstrain_rule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Normal_ruleContext extends Reasoning_ruleContext {
		public Rule_headContext rule_head() {
			return getRuleContext(Rule_headContext.class,0);
		}
		public TerminalNode IF() { return getToken(AspParser.IF, 0); }
		public Rule_bodyContext rule_body() {
			return getRuleContext(Rule_bodyContext.class,0);
		}
		public TerminalNode DOT() { return getToken(AspParser.DOT, 0); }
		public Normal_ruleContext(Reasoning_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterNormal_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitNormal_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitNormal_rule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Fact_ruleContext extends Reasoning_ruleContext {
		public Rule_headContext rule_head() {
			return getRuleContext(Rule_headContext.class,0);
		}
		public TerminalNode DOT() { return getToken(AspParser.DOT, 0); }
		public Fact_ruleContext(Reasoning_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterFact_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitFact_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitFact_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reasoning_ruleContext reasoning_rule() throws RecognitionException {
		Reasoning_ruleContext _localctx = new Reasoning_ruleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_reasoning_rule);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new Fact_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				rule_head();
				setState(82);
				match(DOT);
				}
				break;
			case 2:
				_localctx = new Constrain_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(IF);
				setState(85);
				rule_body();
				setState(86);
				match(DOT);
				}
				break;
			case 3:
				_localctx = new Normal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				rule_head();
				setState(89);
				match(IF);
				setState(90);
				rule_body();
				setState(91);
				match(DOT);
				}
				break;
			case 4:
				_localctx = new Soft_constrainContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				match(SOFT_IF);
				setState(94);
				rule_body();
				setState(95);
				match(DOT);
				setState(96);
				match(LSBRACK);
				setState(97);
				integer();
				setState(100);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(98);
					match(AT);
					setState(99);
					integer();
					}
				}

				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(102);
					match(COMMA);
					setState(103);
					param();
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(109);
				match(RSBRACK);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<Reasoning_ruleContext> reasoning_rule() {
			return getRuleContexts(Reasoning_ruleContext.class);
		}
		public Reasoning_ruleContext reasoning_rule(int i) {
			return getRuleContext(Reasoning_ruleContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << IF) | (1L << SOFT_IF) | (1L << PREDICATE))) != 0)) {
				{
				{
				setState(113);
				reasoning_rule();
				}
				}
				setState(118);
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

	public static class Answer_setContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public Answer_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterAnswer_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitAnswer_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitAnswer_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Answer_setContext answer_set() throws RecognitionException {
		Answer_setContext _localctx = new Answer_setContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_answer_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << PREDICATE))) != 0)) {
				{
				{
				setState(119);
				literal();
				}
				}
				setState(124);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u0080\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\5\2\32\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\5\6\'\n\6\3\6\5\6*\n\6\3\7\7\7-\n\7\f\7\16\7\60\13\7\3\7\5\7\63\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7:\n\7\f\7\16\7=\13\7\5\7?\n\7\3\7\5\7B\n\7\3\b"+
		"\3\b\3\b\7\bG\n\b\f\b\16\bJ\13\b\3\t\3\t\3\t\7\tO\n\t\f\t\16\tR\13\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\ng\n\n\3\n\3\n\7\nk\n\n\f\n\16\nn\13\n\3\n\3\n\5\nr\n\n\3\13\7"+
		"\13u\n\13\f\13\16\13x\13\13\3\f\7\f{\n\f\f\f\16\f~\13\f\3\f\2\2\r\2\4"+
		"\6\b\n\f\16\20\22\24\26\2\3\3\2\23\24\u0086\2\31\3\2\2\2\4\35\3\2\2\2"+
		"\6\37\3\2\2\2\b!\3\2\2\2\n)\3\2\2\2\f.\3\2\2\2\16C\3\2\2\2\20K\3\2\2\2"+
		"\22q\3\2\2\2\24v\3\2\2\2\26|\3\2\2\2\30\32\7\r\2\2\31\30\3\2\2\2\31\32"+
		"\3\2\2\2\32\33\3\2\2\2\33\34\t\2\2\2\34\3\3\2\2\2\35\36\7\25\2\2\36\5"+
		"\3\2\2\2\37 \7\26\2\2 \7\3\2\2\2!\"\7\27\2\2\"\t\3\2\2\2#\'\5\2\2\2$\'"+
		"\5\4\3\2%\'\5\6\4\2&#\3\2\2\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(*\5\b\5\2"+
		")&\3\2\2\2)(\3\2\2\2*\13\3\2\2\2+-\7\16\2\2,+\3\2\2\2-\60\3\2\2\2.,\3"+
		"\2\2\2./\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61\63\7\r\2\2\62\61\3\2\2\2\62"+
		"\63\3\2\2\2\63\64\3\2\2\2\64A\5\6\4\2\65>\7\3\2\2\66;\5\n\6\2\678\7\t"+
		"\2\28:\5\n\6\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<?\3\2\2\2=;\3"+
		"\2\2\2>\66\3\2\2\2>?\3\2\2\2?@\3\2\2\2@B\7\4\2\2A\65\3\2\2\2AB\3\2\2\2"+
		"B\r\3\2\2\2CH\5\f\7\2DE\7\13\2\2EG\5\f\7\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2"+
		"\2HI\3\2\2\2I\17\3\2\2\2JH\3\2\2\2KP\5\f\7\2LM\7\t\2\2MO\5\f\7\2NL\3\2"+
		"\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\21\3\2\2\2RP\3\2\2\2ST\5\16\b\2TU"+
		"\7\n\2\2Ur\3\2\2\2VW\7\17\2\2WX\5\20\t\2XY\7\n\2\2Yr\3\2\2\2Z[\5\16\b"+
		"\2[\\\7\17\2\2\\]\5\20\t\2]^\7\n\2\2^r\3\2\2\2_`\7\20\2\2`a\5\20\t\2a"+
		"b\7\n\2\2bc\7\5\2\2cf\5\2\2\2de\7\21\2\2eg\5\2\2\2fd\3\2\2\2fg\3\2\2\2"+
		"gl\3\2\2\2hi\7\t\2\2ik\5\n\6\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2"+
		"mo\3\2\2\2nl\3\2\2\2op\7\6\2\2pr\3\2\2\2qS\3\2\2\2qV\3\2\2\2qZ\3\2\2\2"+
		"q_\3\2\2\2r\23\3\2\2\2su\5\22\n\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2"+
		"\2\2w\25\3\2\2\2xv\3\2\2\2y{\5\f\7\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3"+
		"\2\2\2}\27\3\2\2\2~|\3\2\2\2\21\31&).\62;>AHPflqv|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}