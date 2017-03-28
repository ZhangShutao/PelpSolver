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
		VBAR=15, COLON=16, SEMI=17, MINUS=18, NAF=19, IF=20, SOFT_IF=21, AT=22, 
		DECIMAL=23, POSITIVE_INT=24, ZERO=25, STRING=26, PREDICATE=27, VAR=28, 
		WS=29, LINE_COMMENT=30;
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
		"'<='", "'>='", "','", "'.'", "'|'", "':'", "';'", "'-'", "'not'", "':-'", 
		"':~'", "'@'", null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"LESS", "GREATER", "EQUAL", "NOTEQUAL", "LESSEQ", "GREATEREQ", "COMMA", 
		"DOT", "VBAR", "COLON", "SEMI", "MINUS", "NAF", "IF", "SOFT_IF", "AT", 
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
	public static class Literal_paramContext extends ParamContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Literal_paramContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).enterLiteral_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AspListener ) ((AspListener)listener).exitLiteral_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AspVisitor ) return ((AspVisitor<? extends T>)visitor).visitLiteral_param(this);
			else return visitor.visitChildren(this);
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
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
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
			case 2:
				_localctx = new Var_paramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				var();
				}
				break;
			case 3:
				_localctx = new Literal_paramContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				literal();
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
			setState(46);
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
			setState(48);
			param();
			setState(49);
			compare_operator();
			setState(50);
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
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAF) {
				{
				{
				setState(52);
				match(NAF);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(58);
				match(MINUS);
				}
			}

			setState(61);
			predicate();
			setState(74);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(62);
				match(LPAREN);
				setState(71);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << POSITIVE_INT) | (1L << ZERO) | (1L << STRING) | (1L << PREDICATE) | (1L << VAR))) != 0)) {
					{
					setState(63);
					param();
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(64);
						match(COMMA);
						setState(65);
						param();
						}
						}
						setState(70);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(73);
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
		public List<TerminalNode> SEMI() { return getTokens(AspParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(AspParser.SEMI, i);
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
			setState(76);
			literal();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR || _la==SEMI) {
				{
				{
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==VBAR || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(78);
				literal();
				}
				}
				setState(83);
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
		public List<TerminalNode> SEMI() { return getTokens(AspParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(AspParser.SEMI, i);
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(84);
				literal();
				}
				break;
			case 2:
				{
				setState(85);
				relation();
				}
				break;
			}
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==SEMI) {
				{
				{
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(91);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(89);
					literal();
					}
					break;
				case 2:
					{
					setState(90);
					relation();
					}
					break;
				}
				}
				}
				setState(97);
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
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new Fact_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				rule_head();
				setState(99);
				match(DOT);
				}
				break;
			case 2:
				_localctx = new Constrain_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(IF);
				setState(102);
				rule_body();
				setState(103);
				match(DOT);
				}
				break;
			case 3:
				_localctx = new Normal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				rule_head();
				setState(106);
				match(IF);
				setState(107);
				rule_body();
				setState(108);
				match(DOT);
				}
				break;
			case 4:
				_localctx = new Soft_constrainContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				match(SOFT_IF);
				setState(111);
				rule_body();
				setState(112);
				match(DOT);
				setState(113);
				match(LSBRACK);
				setState(114);
				integer();
				setState(117);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(115);
					match(AT);
					setState(116);
					integer();
					}
				}

				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(119);
					match(COMMA);
					setState(120);
					param();
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(126);
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
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << IF) | (1L << SOFT_IF) | (1L << PREDICATE))) != 0)) {
				{
				{
				setState(130);
				reasoning_rule();
				}
				}
				setState(135);
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
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << PREDICATE))) != 0)) {
				{
				{
				setState(136);
				literal();
				}
				}
				setState(141);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u0091\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\5\2\36\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\5\6+\n\6\3\6\3\6\5\6/\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\t\7\t8\n\t\f\t\16\t;\13\t\3\t\5\t>\n\t\3\t\3\t\3\t\3\t\3\t\7\tE\n\t\f"+
		"\t\16\tH\13\t\5\tJ\n\t\3\t\5\tM\n\t\3\n\3\n\3\n\7\nR\n\n\f\n\16\nU\13"+
		"\n\3\13\3\13\5\13Y\n\13\3\13\3\13\3\13\5\13^\n\13\7\13`\n\13\f\13\16\13"+
		"c\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\fx\n\f\3\f\3\f\7\f|\n\f\f\f\16\f\177\13\f\3\f\3\f\5\f"+
		"\u0083\n\f\3\r\7\r\u0086\n\r\f\r\16\r\u0089\13\r\3\16\7\16\u008c\n\16"+
		"\f\16\16\16\u008f\13\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2"+
		"\6\3\2\32\33\3\2\t\16\4\2\21\21\23\23\4\2\17\17\23\23\u0098\2\35\3\2\2"+
		"\2\4!\3\2\2\2\6#\3\2\2\2\b%\3\2\2\2\n.\3\2\2\2\f\60\3\2\2\2\16\62\3\2"+
		"\2\2\209\3\2\2\2\22N\3\2\2\2\24X\3\2\2\2\26\u0082\3\2\2\2\30\u0087\3\2"+
		"\2\2\32\u008d\3\2\2\2\34\36\7\24\2\2\35\34\3\2\2\2\35\36\3\2\2\2\36\37"+
		"\3\2\2\2\37 \t\2\2\2 \3\3\2\2\2!\"\7\34\2\2\"\5\3\2\2\2#$\7\35\2\2$\7"+
		"\3\2\2\2%&\7\36\2\2&\t\3\2\2\2\'+\5\2\2\2(+\5\4\3\2)+\5\6\4\2*\'\3\2\2"+
		"\2*(\3\2\2\2*)\3\2\2\2+/\3\2\2\2,/\5\b\5\2-/\5\20\t\2.*\3\2\2\2.,\3\2"+
		"\2\2.-\3\2\2\2/\13\3\2\2\2\60\61\t\3\2\2\61\r\3\2\2\2\62\63\5\n\6\2\63"+
		"\64\5\f\7\2\64\65\5\n\6\2\65\17\3\2\2\2\668\7\25\2\2\67\66\3\2\2\28;\3"+
		"\2\2\29\67\3\2\2\29:\3\2\2\2:=\3\2\2\2;9\3\2\2\2<>\7\24\2\2=<\3\2\2\2"+
		"=>\3\2\2\2>?\3\2\2\2?L\5\6\4\2@I\7\3\2\2AF\5\n\6\2BC\7\17\2\2CE\5\n\6"+
		"\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IA\3\2\2"+
		"\2IJ\3\2\2\2JK\3\2\2\2KM\7\4\2\2L@\3\2\2\2LM\3\2\2\2M\21\3\2\2\2NS\5\20"+
		"\t\2OP\t\4\2\2PR\5\20\t\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\23"+
		"\3\2\2\2US\3\2\2\2VY\5\20\t\2WY\5\16\b\2XV\3\2\2\2XW\3\2\2\2Ya\3\2\2\2"+
		"Z]\t\5\2\2[^\5\20\t\2\\^\5\16\b\2][\3\2\2\2]\\\3\2\2\2^`\3\2\2\2_Z\3\2"+
		"\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\25\3\2\2\2ca\3\2\2\2de\5\22\n\2ef"+
		"\7\20\2\2f\u0083\3\2\2\2gh\7\26\2\2hi\5\24\13\2ij\7\20\2\2j\u0083\3\2"+
		"\2\2kl\5\22\n\2lm\7\26\2\2mn\5\24\13\2no\7\20\2\2o\u0083\3\2\2\2pq\7\27"+
		"\2\2qr\5\24\13\2rs\7\20\2\2st\7\5\2\2tw\5\2\2\2uv\7\30\2\2vx\5\2\2\2w"+
		"u\3\2\2\2wx\3\2\2\2x}\3\2\2\2yz\7\17\2\2z|\5\n\6\2{y\3\2\2\2|\177\3\2"+
		"\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\6\2"+
		"\2\u0081\u0083\3\2\2\2\u0082d\3\2\2\2\u0082g\3\2\2\2\u0082k\3\2\2\2\u0082"+
		"p\3\2\2\2\u0083\27\3\2\2\2\u0084\u0086\5\26\f\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\31\3\2\2"+
		"\2\u0089\u0087\3\2\2\2\u008a\u008c\5\20\t\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\33\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\23\35*.9=FILSX]aw}\u0082\u0087\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}