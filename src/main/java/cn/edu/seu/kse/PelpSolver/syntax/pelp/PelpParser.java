// Generated from Pelp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.PelpSolver.syntax.pelp;
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
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, COMMA=7, 
		DOT=8, VBAR=9, COLON=10, MINUS=11, NAF=12, IF=13, KNOW=14, DECIMAL=15, 
		POSITIVE_INT=16, ZERO=17, STRING=18, PREDICATE=19, VAR=20, WS=21, LINE_COMMENT=22;
	public static final int
		RULE_integer = 0, RULE_decimal = 1, RULE_string = 2, RULE_predicate = 3, 
		RULE_var = 4, RULE_param = 5, RULE_objective_literal = 6, RULE_subjective_literal = 7, 
		RULE_rule_head = 8, RULE_rule_body = 9, RULE_hard_rule = 10, RULE_soft_rule = 11, 
		RULE_program = 12;
	public static final String[] ruleNames = {
		"integer", "decimal", "string", "predicate", "var", "param", "objective_literal", 
		"subjective_literal", "rule_head", "rule_body", "hard_rule", "soft_rule", 
		"program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "'.'", "'|'", "':'", 
		"'-'", "'not'", "':-'", "'K'", null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"COMMA", "DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "KNOW", "DECIMAL", 
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
			setState(33);
			switch (_input.LA(1)) {
			case DECIMAL:
				{
				setState(31);
				match(DECIMAL);
				}
				break;
			case MINUS:
			case POSITIVE_INT:
			case ZERO:
				{
				setState(32);
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
			setState(35);
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
			setState(37);
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
			setState(39);
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
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PelpListener ) ((PelpListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PelpVisitor ) return ((PelpVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(41);
				integer();
				}
				break;
			case 2:
				{
				setState(42);
				decimal();
				}
				break;
			case 3:
				{
				setState(43);
				string();
				}
				break;
			case 4:
				{
				setState(44);
				var();
				}
				break;
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

	public static class Objective_literalContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NAF() { return getToken(PelpParser.NAF, 0); }
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
		enterRule(_localctx, 12, RULE_objective_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if (_la==NAF) {
				{
				setState(47);
				match(NAF);
				}
			}

			setState(51);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(50);
				match(MINUS);
				}
			}

			setState(53);
			predicate();
			setState(66);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(54);
				match(LPAREN);
				setState(63);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << KNOW) | (1L << DECIMAL) | (1L << POSITIVE_INT) | (1L << ZERO) | (1L << STRING) | (1L << VAR))) != 0)) {
					{
					setState(55);
					param();
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(56);
						match(COMMA);
						setState(57);
						param();
						}
						}
						setState(62);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(65);
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
		public TerminalNode LCBRACK() { return getToken(PelpParser.LCBRACK, 0); }
		public TerminalNode RPAREN() { return getToken(PelpParser.RPAREN, 0); }
		public TerminalNode RCBRACK() { return getToken(PelpParser.RCBRACK, 0); }
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
		enterRule(_localctx, 14, RULE_subjective_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(KNOW);
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==LPAREN || _la==LCBRACK) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(70);
			decimal();
			setState(71);
			match(COMMA);
			setState(72);
			decimal();
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==RPAREN || _la==RCBRACK) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(74);
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

	public static class Rule_headContext extends ParserRuleContext {
		public List<Objective_literalContext> objective_literal() {
			return getRuleContexts(Objective_literalContext.class);
		}
		public Objective_literalContext objective_literal(int i) {
			return getRuleContext(Objective_literalContext.class,i);
		}
		public TerminalNode VBAR() { return getToken(PelpParser.VBAR, 0); }
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
		enterRule(_localctx, 16, RULE_rule_head);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			objective_literal();
			{
			setState(77);
			match(VBAR);
			setState(78);
			objective_literal();
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
		enterRule(_localctx, 18, RULE_rule_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			switch (_input.LA(1)) {
			case MINUS:
			case NAF:
			case PREDICATE:
				{
				setState(80);
				objective_literal();
				}
				break;
			case KNOW:
				{
				setState(81);
				subjective_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(84);
				match(COMMA);
				setState(87);
				switch (_input.LA(1)) {
				case MINUS:
				case NAF:
				case PREDICATE:
					{
					setState(85);
					objective_literal();
					}
					break;
				case KNOW:
					{
					setState(86);
					subjective_literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(93);
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
		enterRule(_localctx, 20, RULE_hard_rule);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new Fact_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				rule_head();
				setState(95);
				match(DOT);
				}
				break;
			case 2:
				_localctx = new Constrain_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(IF);
				setState(98);
				rule_body();
				setState(99);
				match(DOT);
				}
				break;
			case 3:
				_localctx = new Normal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				rule_head();
				setState(102);
				match(IF);
				setState(103);
				rule_body();
				setState(104);
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
		public TerminalNode LPAREN() { return getToken(PelpParser.LPAREN, 0); }
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PelpParser.RPAREN, 0); }
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
		enterRule(_localctx, 22, RULE_soft_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			hard_rule();
			setState(109);
			match(LPAREN);
			setState(110);
			decimal();
			setState(111);
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
		enterRule(_localctx, 24, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << IF) | (1L << PREDICATE))) != 0)) {
				{
				setState(115);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(113);
					soft_rule();
					}
					break;
				case 2:
					{
					setState(114);
					hard_rule();
					}
					break;
				}
				}
				setState(119);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30{\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\5\2\36\n\2\3\2\3\2\3\3\3\3\5\3$\n\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7\60\n\7\3\b\5\b\63\n\b\3\b\5\b\66"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\7\b=\n\b\f\b\16\b@\13\b\5\bB\n\b\3\b\5\bE\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\5\13U\n\13"+
		"\3\13\3\13\3\13\5\13Z\n\13\7\13\\\n\13\f\13\16\13_\13\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fm\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\7\16v\n\16\f\16\16\16y\13\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\2\6\3\2\22\23\4\2\20\20\26\26\4\2\3\3\7\7\4\2\4\4\b\b~\2\35\3\2"+
		"\2\2\4#\3\2\2\2\6%\3\2\2\2\b\'\3\2\2\2\n)\3\2\2\2\f/\3\2\2\2\16\62\3\2"+
		"\2\2\20F\3\2\2\2\22N\3\2\2\2\24T\3\2\2\2\26l\3\2\2\2\30n\3\2\2\2\32w\3"+
		"\2\2\2\34\36\7\r\2\2\35\34\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \t\2"+
		"\2\2 \3\3\2\2\2!$\7\21\2\2\"$\5\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2"+
		"%&\7\24\2\2&\7\3\2\2\2\'(\7\25\2\2(\t\3\2\2\2)*\t\3\2\2*\13\3\2\2\2+\60"+
		"\5\2\2\2,\60\5\4\3\2-\60\5\6\4\2.\60\5\n\6\2/+\3\2\2\2/,\3\2\2\2/-\3\2"+
		"\2\2/.\3\2\2\2\60\r\3\2\2\2\61\63\7\16\2\2\62\61\3\2\2\2\62\63\3\2\2\2"+
		"\63\65\3\2\2\2\64\66\7\r\2\2\65\64\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2"+
		"\67D\5\b\5\28A\7\3\2\29>\5\f\7\2:;\7\t\2\2;=\5\f\7\2<:\3\2\2\2=@\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2A9\3\2\2\2AB\3\2\2\2BC\3\2\2"+
		"\2CE\7\4\2\2D8\3\2\2\2DE\3\2\2\2E\17\3\2\2\2FG\7\20\2\2GH\t\4\2\2HI\5"+
		"\4\3\2IJ\7\t\2\2JK\5\4\3\2KL\t\5\2\2LM\5\16\b\2M\21\3\2\2\2NO\5\16\b\2"+
		"OP\7\13\2\2PQ\5\16\b\2Q\23\3\2\2\2RU\5\16\b\2SU\5\20\t\2TR\3\2\2\2TS\3"+
		"\2\2\2U]\3\2\2\2VY\7\t\2\2WZ\5\16\b\2XZ\5\20\t\2YW\3\2\2\2YX\3\2\2\2Z"+
		"\\\3\2\2\2[V\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\25\3\2\2\2_]\3\2"+
		"\2\2`a\5\22\n\2ab\7\n\2\2bm\3\2\2\2cd\7\17\2\2de\5\24\13\2ef\7\n\2\2f"+
		"m\3\2\2\2gh\5\22\n\2hi\7\17\2\2ij\5\24\13\2jk\7\n\2\2km\3\2\2\2l`\3\2"+
		"\2\2lc\3\2\2\2lg\3\2\2\2m\27\3\2\2\2no\5\26\f\2op\7\3\2\2pq\5\4\3\2qr"+
		"\7\4\2\2r\31\3\2\2\2sv\5\30\r\2tv\5\26\f\2us\3\2\2\2ut\3\2\2\2vy\3\2\2"+
		"\2wu\3\2\2\2wx\3\2\2\2x\33\3\2\2\2yw\3\2\2\2\20\35#/\62\65>ADTY]luw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}