// Generated from Pelp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.syntax.pelp;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

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
			setState(47);
			switch (_input.LA(1)) {
			case MINUS:
			case POSITIVE_INT:
			case ZERO:
			case STRING:
			case PREDICATE:
				_localctx = new Const_paramContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				switch (_input.LA(1)) {
				case MINUS:
				case POSITIVE_INT:
				case ZERO:
					{
					setState(41);
					integer();
					}
					break;
				case STRING:
					{
					setState(42);
					string();
					}
					break;
				case PREDICATE:
					{
					setState(43);
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
				setState(46);
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
			setState(50);
			_la = _input.LA(1);
			if (_la==NAF) {
				{
				setState(49);
				match(NAF);
				}
			}

			setState(53);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(52);
				match(MINUS);
				}
			}

			setState(55);
			predicate();
			setState(68);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(56);
				match(LPAREN);
				setState(65);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << KNOW) | (1L << POSITIVE_INT) | (1L << ZERO) | (1L << STRING) | (1L << PREDICATE) | (1L << VAR))) != 0)) {
					{
					setState(57);
					param();
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(58);
						match(COMMA);
						setState(59);
						param();
						}
						}
						setState(64);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(67);
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
		enterRule(_localctx, 14, RULE_subjective_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(KNOW);
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==LPAREN || _la==LSBRACK) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(72);
			decimal();
			setState(73);
			match(COMMA);
			setState(74);
			decimal();
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==RPAREN || _la==RSBRACK) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(76);
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
		enterRule(_localctx, 16, RULE_rule_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			objective_literal();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(79);
				match(VBAR);
				setState(80);
				objective_literal();
				}
				}
				setState(85);
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
			setState(88);
			switch (_input.LA(1)) {
			case MINUS:
			case NAF:
			case PREDICATE:
				{
				setState(86);
				objective_literal();
				}
				break;
			case KNOW:
				{
				setState(87);
				subjective_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(90);
				match(COMMA);
				setState(93);
				switch (_input.LA(1)) {
				case MINUS:
				case NAF:
				case PREDICATE:
					{
					setState(91);
					objective_literal();
					}
					break;
				case KNOW:
					{
					setState(92);
					subjective_literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(99);
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
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new Fact_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				rule_head();
				setState(101);
				match(DOT);
				}
				break;
			case 2:
				_localctx = new Constrain_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(IF);
				setState(104);
				rule_body();
				setState(105);
				match(DOT);
				}
				break;
			case 3:
				_localctx = new Normal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				rule_head();
				setState(108);
				match(IF);
				setState(109);
				rule_body();
				setState(110);
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
		enterRule(_localctx, 22, RULE_soft_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			hard_rule();
			setState(115);
			match(LSBRACK);
			setState(116);
			decimal();
			setState(117);
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
		enterRule(_localctx, 24, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NAF) | (1L << IF) | (1L << PREDICATE))) != 0)) {
				{
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(119);
					soft_rule();
					}
					break;
				case 2:
					{
					setState(120);
					hard_rule();
					}
					break;
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u0081\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\5\2\36\n\2\3\2\3\2\3\3\3\3\5\3$\n"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7/\n\7\3\7\5\7\62\n\7\3\b\5\b"+
		"\65\n\b\3\b\5\b8\n\b\3\b\3\b\3\b\3\b\3\b\7\b?\n\b\f\b\16\bB\13\b\5\bD"+
		"\n\b\3\b\5\bG\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\nT\n\n"+
		"\f\n\16\nW\13\n\3\13\3\13\5\13[\n\13\3\13\3\13\3\13\5\13`\n\13\7\13b\n"+
		"\13\f\13\16\13e\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\fs\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\7\16|\n\16\f\16\16\16\177\13\16"+
		"\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\6\3\2\22\23\4\2\20\20"+
		"\26\26\4\2\3\3\5\5\4\2\4\4\6\6\u0085\2\35\3\2\2\2\4#\3\2\2\2\6%\3\2\2"+
		"\2\b\'\3\2\2\2\n)\3\2\2\2\f\61\3\2\2\2\16\64\3\2\2\2\20H\3\2\2\2\22P\3"+
		"\2\2\2\24Z\3\2\2\2\26r\3\2\2\2\30t\3\2\2\2\32}\3\2\2\2\34\36\7\r\2\2\35"+
		"\34\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \t\2\2\2 \3\3\2\2\2!$\7\21"+
		"\2\2\"$\5\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%&\7\24\2\2&\7\3\2\2\2"+
		"\'(\7\25\2\2(\t\3\2\2\2)*\t\3\2\2*\13\3\2\2\2+/\5\2\2\2,/\5\6\4\2-/\5"+
		"\b\5\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\62\3\2\2\2\60\62\5\n\6\2\61.\3\2"+
		"\2\2\61\60\3\2\2\2\62\r\3\2\2\2\63\65\7\16\2\2\64\63\3\2\2\2\64\65\3\2"+
		"\2\2\65\67\3\2\2\2\668\7\r\2\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29F\5"+
		"\b\5\2:C\7\3\2\2;@\5\f\7\2<=\7\t\2\2=?\5\f\7\2><\3\2\2\2?B\3\2\2\2@>\3"+
		"\2\2\2@A\3\2\2\2AD\3\2\2\2B@\3\2\2\2C;\3\2\2\2CD\3\2\2\2DE\3\2\2\2EG\7"+
		"\4\2\2F:\3\2\2\2FG\3\2\2\2G\17\3\2\2\2HI\7\20\2\2IJ\t\4\2\2JK\5\4\3\2"+
		"KL\7\t\2\2LM\5\4\3\2MN\t\5\2\2NO\5\16\b\2O\21\3\2\2\2PU\5\16\b\2QR\7\13"+
		"\2\2RT\5\16\b\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\23\3\2\2\2WU"+
		"\3\2\2\2X[\5\16\b\2Y[\5\20\t\2ZX\3\2\2\2ZY\3\2\2\2[c\3\2\2\2\\_\7\t\2"+
		"\2]`\5\16\b\2^`\5\20\t\2_]\3\2\2\2_^\3\2\2\2`b\3\2\2\2a\\\3\2\2\2be\3"+
		"\2\2\2ca\3\2\2\2cd\3\2\2\2d\25\3\2\2\2ec\3\2\2\2fg\5\22\n\2gh\7\n\2\2"+
		"hs\3\2\2\2ij\7\17\2\2jk\5\24\13\2kl\7\n\2\2ls\3\2\2\2mn\5\22\n\2no\7\17"+
		"\2\2op\5\24\13\2pq\7\n\2\2qs\3\2\2\2rf\3\2\2\2ri\3\2\2\2rm\3\2\2\2s\27"+
		"\3\2\2\2tu\5\26\f\2uv\7\5\2\2vw\5\4\3\2wx\7\6\2\2x\31\3\2\2\2y|\5\30\r"+
		"\2z|\5\26\f\2{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\33"+
		"\3\2\2\2\177}\3\2\2\2\22\35#.\61\64\67@CFUZ_cr{}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}