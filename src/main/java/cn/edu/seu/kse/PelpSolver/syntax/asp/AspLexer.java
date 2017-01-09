// Generated from Asp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.PelpSolver.syntax.asp;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AspLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, COMMA=7, 
		DOT=8, VBAR=9, COLON=10, MINUS=11, NAF=12, IF=13, SOFT_IF=14, AT=15, DECIMAL=16, 
		POSITIVE_INT=17, ZERO=18, STRING=19, PREDICATE=20, VAR=21, WS=22, LINE_COMMENT=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", "COMMA", 
		"DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "SOFT_IF", "AT", "DECIMAL", 
		"POSITIVE_INT", "ZERO", "STRING", "PREDICATE", "VAR", "WS", "LINE_COMMENT"
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


	public AspLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Asp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 22:
			LINE_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u009c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\21\5\21U\n\21\3\21\3\21\7\21Y\n\21\f\21\16\21\\\13\21\3\21\5\21"+
		"_\n\21\3\21\3\21\6\21c\n\21\r\21\16\21d\3\22\3\22\7\22i\n\22\f\22\16\22"+
		"l\13\22\3\23\3\23\3\24\3\24\3\24\3\24\7\24t\n\24\f\24\16\24w\13\24\3\24"+
		"\3\24\3\25\3\25\7\25}\n\25\f\25\16\25\u0080\13\25\3\26\3\26\7\26\u0084"+
		"\n\26\f\26\16\26\u0087\13\26\3\27\6\27\u008a\n\27\r\27\16\27\u008b\3\27"+
		"\3\27\3\30\3\30\7\30\u0092\n\30\f\30\16\30\u0095\13\30\3\30\5\30\u0098"+
		"\n\30\3\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\n"+
		"\3\2\63;\3\2\62;\3\2$$\4\2aac|\6\2\62;C\\aac|\3\2C\\\5\2\13\f\17\17\""+
		"\"\4\2\f\f\17\17\u00a7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3"+
		"\2\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2\2\25C"+
		"\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33K\3\2\2\2\35N\3\2\2\2\37Q\3\2\2\2!"+
		"T\3\2\2\2#f\3\2\2\2%m\3\2\2\2\'o\3\2\2\2)z\3\2\2\2+\u0081\3\2\2\2-\u0089"+
		"\3\2\2\2/\u008f\3\2\2\2\61\62\7*\2\2\62\4\3\2\2\2\63\64\7+\2\2\64\6\3"+
		"\2\2\2\65\66\7]\2\2\66\b\3\2\2\2\678\7_\2\28\n\3\2\2\29:\7}\2\2:\f\3\2"+
		"\2\2;<\7\177\2\2<\16\3\2\2\2=>\7.\2\2>\20\3\2\2\2?@\7\60\2\2@\22\3\2\2"+
		"\2AB\7~\2\2B\24\3\2\2\2CD\7<\2\2D\26\3\2\2\2EF\7/\2\2F\30\3\2\2\2GH\7"+
		"p\2\2HI\7q\2\2IJ\7v\2\2J\32\3\2\2\2KL\7<\2\2LM\7/\2\2M\34\3\2\2\2NO\7"+
		"<\2\2OP\7\u0080\2\2P\36\3\2\2\2QR\7B\2\2R \3\2\2\2SU\5\27\f\2TS\3\2\2"+
		"\2TU\3\2\2\2U^\3\2\2\2VZ\t\2\2\2WY\t\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2"+
		"\2\2Z[\3\2\2\2[_\3\2\2\2\\Z\3\2\2\2]_\5%\23\2^V\3\2\2\2^]\3\2\2\2_`\3"+
		"\2\2\2`b\5\21\t\2ac\t\3\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\""+
		"\3\2\2\2fj\t\2\2\2gi\t\3\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k"+
		"$\3\2\2\2lj\3\2\2\2mn\7\62\2\2n&\3\2\2\2ou\7$\2\2pq\7^\2\2qt\7$\2\2rt"+
		"\n\4\2\2sp\3\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2w"+
		"u\3\2\2\2xy\7$\2\2y(\3\2\2\2z~\t\5\2\2{}\t\6\2\2|{\3\2\2\2}\u0080\3\2"+
		"\2\2~|\3\2\2\2~\177\3\2\2\2\177*\3\2\2\2\u0080~\3\2\2\2\u0081\u0085\t"+
		"\7\2\2\u0082\u0084\t\6\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086,\3\2\2\2\u0087\u0085\3\2\2\2"+
		"\u0088\u008a\t\b\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\27\2\2"+
		"\u008e.\3\2\2\2\u008f\u0093\7\'\2\2\u0090\u0092\n\t\2\2\u0091\u0090\3"+
		"\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0098\7\17\2\2\u0097\u0096\3"+
		"\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\f\2\2\u009a"+
		"\u009b\b\30\3\2\u009b\60\3\2\2\2\17\2TZ^djsu~\u0085\u008b\u0093\u0097"+
		"\4\b\2\2\3\30\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}