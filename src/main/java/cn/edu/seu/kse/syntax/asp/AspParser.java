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
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, LESS=7, 
		GREATER=8, EQUAL=9, NOTEQUAL=10, LESSEQ=11, GREATEREQ=12, COMMA=13, DOT=14, 
		VBAR=15, COLON=16, MINUS=17, NAF=18, IF=19, SOFT_IF=20, AT=21, DECIMAL=22, 
		POSITIVE_INT=23, ZERO=24, STRING=25, PREDICATE=26, VAR=27, WS=28, LINE_COMMENT=29;
	public static final int
		RULE_integer = 0, RULE_string = 1, RULE_predicate = 2, RULE_var = 3, RULE_param = 4, 
		RULE_compare_operator = 5, RULE_relation = 6, RULE_literal = 7, RULE_rule_head = 8, 
		RULE_rule_body = 9, RULE_reasoning_rule = 10, RULE_program = 11, RULE_answer_set = 12;
	public static final String[] ruleNames = {
		"integer", "string", "predicate", "var", "param", "compare_operator", 
		"relation", "literal", "rule_head", "rule_body", "reasoning_rule", "program", 
		"answer_set"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'", "'='", "'!='", 
		"'<='", "'>='", "','", "'.'", "'|'", "':'", "'-'", "'not'", "':-'", "':~'", 
		"'@'", null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"LESS", "GREATER", "EQUAL", "NOTEQUAL", "LESSEQ", "GREATEREQ", "COMMA", 
		"DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "SOFT_IF", "AT", "DECIMAL", 
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
			setState(27);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(26);
				match(MINUS);
				}
			}

			setState(29);
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
			setState(31);
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
			setState(33);
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
			setState(35);
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
			setState(43);
			switch (_input.LA(1)) {
			case MINUS:
			case POSITIVE_INT:
			case ZERO:
			case STRING:
			case PREDICATE:
				_localctx = new Const_paramContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				switch (_input.LA(1)) {
				case MINUS:
				case POSITIVE_INT:
				case ZERO:
					{
					setState(37);
					integer();
					}
					break;
				case STRING:
					{
					setState(38);
					string();
					}
					break;
				case PREDICATE:
					{
					setState(39);
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
				setState(42);
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
		public TerminalNode LESS() { return getToken(AspParser.LESS, 0); }
		public TerminalNode LESSEQ() { return getToken(AspParser.LESSEQ, 0); }
		public TerminalNode GREATER() { return getToken(AspParser.GREATER, 0); }
		public TerminalNode GREATEREQ() { return getToken(AspParser.GREATEREQ, 0); }
		public TerminalNode EQUAL() { return getToken(AspParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(AspParser.NOTEQUAL, 0); }
		public Compare_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterCompare_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitCompare_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitCompare_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_operatorContext compare_operator() throws RecognitionException {
		Compare_operatorContext _localctx = new Compare_operatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_compare_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
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
			if ( listener instanceof AspListener ) ((AspListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			param();
			setState(48);
			compare_operator();
			setState(49);
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
		enterRule(_localctx, 14, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAF) {
				{
				{
				setState(51);
				match(NAF);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(57);
				match(MINUS);
				}
			}

			setState(60);
			predicate();
			setState(73);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(61);
				match(LPAREN);
				setState(70);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << POSITIVE_INT) | (1L << ZERO) | (1L << STRING) | (1L << PREDICATE) | (1L << VAR))) != 0)) {
					{
					setState(62);
					param();
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(63);
						match(COMMA);
						setState(64);
						param();
						}
						}
						setState(69);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(72);
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
		enterRule(_localctx, 16, RULE_rule_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			literal();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(76);
				match(VBAR);
				setState(77);
				literal();
				}
				}
				setState(82);
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
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
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
		enterRule(_localctx, 18, RULE_rule_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(83);
				literal();
				}
				break;
			case 2:
				{
				setState(84);
				relation();
				}
				break;
			}
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(87);
				match(COMMA);
				setState(90);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(88);
					literal();
					}
					break;
				case 2:
					{
					setState(89);
					relation();
					}
					break;
				}
				}
				}
				setState(96);
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
		enterRule(_localctx, 20, RULE_reasoning_rule);
		int _la;
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new Fact_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				rule_head();
				setState(98);
				match(DOT);
				}
				break;
			case 2:
				_localctx = new Constrain_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(IF);
				setState(101);
				rule_body();
				setState(102);
				match(DOT);
				}
				break;
			case 3:
				_localctx = new Normal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				rule_head();
				setState(105);
				match(IF);
				setState(106);
				rule_body();
				setState(107);
				match(DOT);
				}
				break;
			case 4:
				_localctx = new Soft_constrainContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(SOFT_IF);
				setState(110);
				rule_body();
				setState(111);
				match(DOT);
				setState(112);
				match(LSBRACK);
				setState(113);
				integer();
				setState(116);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(114);
					match(AT);
					setState(115);
					integer();
					}
				}

				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(118);
					match(COMMA);
					setState(119);
					param();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
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
		enterRule(_localctx, 22, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << IF) | (1L << SOFT_IF) | (1L << PREDICATE))) != 0)) {
				{
				{
				setState(129);
				reasoning_rule();
				}
				}
				setState(134);
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
		enterRule(_localctx, 24, RULE_answer_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << PREDICATE))) != 0)) {
				{
				{
				setState(135);
				literal();
				}
				}
				setState(140);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u0090\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\5\2\36\n\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\5\6+\n\6\3\6\5\6.\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t"+
		"\7\t\67\n\t\f\t\16\t:\13\t\3\t\5\t=\n\t\3\t\3\t\3\t\3\t\3\t\7\tD\n\t\f"+
		"\t\16\tG\13\t\5\tI\n\t\3\t\5\tL\n\t\3\n\3\n\3\n\7\nQ\n\n\f\n\16\nT\13"+
		"\n\3\13\3\13\5\13X\n\13\3\13\3\13\3\13\5\13]\n\13\7\13_\n\13\f\13\16\13"+
		"b\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\fw\n\f\3\f\3\f\7\f{\n\f\f\f\16\f~\13\f\3\f\3\f\5\f\u0082"+
		"\n\f\3\r\7\r\u0085\n\r\f\r\16\r\u0088\13\r\3\16\7\16\u008b\n\16\f\16\16"+
		"\16\u008e\13\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\3\2\31"+
		"\32\3\2\t\16\u0096\2\35\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b%\3\2\2\2\n-\3"+
		"\2\2\2\f/\3\2\2\2\16\61\3\2\2\2\208\3\2\2\2\22M\3\2\2\2\24W\3\2\2\2\26"+
		"\u0081\3\2\2\2\30\u0086\3\2\2\2\32\u008c\3\2\2\2\34\36\7\23\2\2\35\34"+
		"\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \t\2\2\2 \3\3\2\2\2!\"\7\33\2"+
		"\2\"\5\3\2\2\2#$\7\34\2\2$\7\3\2\2\2%&\7\35\2\2&\t\3\2\2\2\'+\5\2\2\2"+
		"(+\5\4\3\2)+\5\6\4\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+.\3\2\2\2,.\5\b\5"+
		"\2-*\3\2\2\2-,\3\2\2\2.\13\3\2\2\2/\60\t\3\2\2\60\r\3\2\2\2\61\62\5\n"+
		"\6\2\62\63\5\f\7\2\63\64\5\n\6\2\64\17\3\2\2\2\65\67\7\24\2\2\66\65\3"+
		"\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2\2;=\7\23\2"+
		"\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>K\5\6\4\2?H\7\3\2\2@E\5\n\6\2AB\7\17"+
		"\2\2BD\5\n\6\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2H@\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JL\7\4\2\2K?\3\2\2\2KL\3\2\2\2L\21\3"+
		"\2\2\2MR\5\20\t\2NO\7\21\2\2OQ\5\20\t\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2"+
		"RS\3\2\2\2S\23\3\2\2\2TR\3\2\2\2UX\5\20\t\2VX\5\16\b\2WU\3\2\2\2WV\3\2"+
		"\2\2X`\3\2\2\2Y\\\7\17\2\2Z]\5\20\t\2[]\5\16\b\2\\Z\3\2\2\2\\[\3\2\2\2"+
		"]_\3\2\2\2^Y\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\25\3\2\2\2b`\3\2\2"+
		"\2cd\5\22\n\2de\7\20\2\2e\u0082\3\2\2\2fg\7\25\2\2gh\5\24\13\2hi\7\20"+
		"\2\2i\u0082\3\2\2\2jk\5\22\n\2kl\7\25\2\2lm\5\24\13\2mn\7\20\2\2n\u0082"+
		"\3\2\2\2op\7\26\2\2pq\5\24\13\2qr\7\20\2\2rs\7\5\2\2sv\5\2\2\2tu\7\27"+
		"\2\2uw\5\2\2\2vt\3\2\2\2vw\3\2\2\2w|\3\2\2\2xy\7\17\2\2y{\5\n\6\2zx\3"+
		"\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080"+
		"\7\6\2\2\u0080\u0082\3\2\2\2\u0081c\3\2\2\2\u0081f\3\2\2\2\u0081j\3\2"+
		"\2\2\u0081o\3\2\2\2\u0082\27\3\2\2\2\u0083\u0085\5\26\f\2\u0084\u0083"+
		"\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\31\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\5\20\t\2\u008a\u0089\3\2\2"+
		"\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\33"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\23\35*-8<EHKRW\\`v|\u0081\u0086\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}