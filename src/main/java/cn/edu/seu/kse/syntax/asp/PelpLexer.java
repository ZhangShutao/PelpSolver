// Generated from Asp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.syntax.asp;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PelpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, COMMA=7, 
		DOT=8, VBAR=9, COLON=10, MINUS=11, NAF=12, IF=13, DECIMAL=14, POSITIVE_INT=15, 
		ZERO=16, STRING=17, PREDICATE=18, VAR=19, WS=20, LINE_COMMENT=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", "COMMA", 
		"DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "DECIMAL", "POSITIVE_INT", 
		"ZERO", "STRING", "PREDICATE", "VAR", "WS", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "'.'", "'|'", "':'", 
		"'-'", "'not'", "':-'", null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"COMMA", "DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "DECIMAL", "POSITIVE_INT", 
		"ZERO", "STRING", "PREDICATE", "VAR", "WS", "LINE_COMMENT"
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


	public PelpLexer(CharStream input) {
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
		case 20:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\5\17L\n\17\3\17\3\17\7\17P\n\17\f\17"+
		"\16\17S\13\17\3\17\5\17V\n\17\3\17\3\17\6\17Z\n\17\r\17\16\17[\3\20\3"+
		"\20\7\20`\n\20\f\20\16\20c\13\20\3\21\3\21\3\22\3\22\3\22\3\22\7\22k\n"+
		"\22\f\22\16\22n\13\22\3\22\3\22\3\23\3\23\7\23t\n\23\f\23\16\23w\13\23"+
		"\3\24\3\24\7\24{\n\24\f\24\16\24~\13\24\3\25\6\25\u0081\n\25\r\25\16\25"+
		"\u0082\3\25\3\25\3\26\3\26\7\26\u0089\n\26\f\26\16\26\u008c\13\26\3\26"+
		"\5\26\u008f\n\26\3\26\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3"+
		"\2\13\3\2\63;\3\2\62;\3\2$$\3\2c|\7\2//\62;C\\aac|\3\2C\\\6\2\62;C\\a"+
		"ac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u009e\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2"+
		"\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25?\3"+
		"\2\2\2\27A\3\2\2\2\31C\3\2\2\2\33G\3\2\2\2\35K\3\2\2\2\37]\3\2\2\2!d\3"+
		"\2\2\2#f\3\2\2\2%q\3\2\2\2\'x\3\2\2\2)\u0080\3\2\2\2+\u0086\3\2\2\2-."+
		"\7*\2\2.\4\3\2\2\2/\60\7+\2\2\60\6\3\2\2\2\61\62\7]\2\2\62\b\3\2\2\2\63"+
		"\64\7_\2\2\64\n\3\2\2\2\65\66\7}\2\2\66\f\3\2\2\2\678\7\177\2\28\16\3"+
		"\2\2\29:\7.\2\2:\20\3\2\2\2;<\7\60\2\2<\22\3\2\2\2=>\7~\2\2>\24\3\2\2"+
		"\2?@\7<\2\2@\26\3\2\2\2AB\7/\2\2B\30\3\2\2\2CD\7p\2\2DE\7q\2\2EF\7v\2"+
		"\2F\32\3\2\2\2GH\7<\2\2HI\7/\2\2I\34\3\2\2\2JL\5\27\f\2KJ\3\2\2\2KL\3"+
		"\2\2\2LU\3\2\2\2MQ\t\2\2\2NP\t\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3"+
		"\2\2\2RV\3\2\2\2SQ\3\2\2\2TV\5!\21\2UM\3\2\2\2UT\3\2\2\2VW\3\2\2\2WY\5"+
		"\21\t\2XZ\t\3\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\36\3\2\2"+
		"\2]a\t\2\2\2^`\t\3\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b \3\2\2"+
		"\2ca\3\2\2\2de\7\62\2\2e\"\3\2\2\2fl\7$\2\2gh\7^\2\2hk\7$\2\2ik\n\4\2"+
		"\2jg\3\2\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2"+
		"\2op\7$\2\2p$\3\2\2\2qu\t\5\2\2rt\t\6\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2"+
		"\2uv\3\2\2\2v&\3\2\2\2wu\3\2\2\2x|\t\7\2\2y{\t\b\2\2zy\3\2\2\2{~\3\2\2"+
		"\2|z\3\2\2\2|}\3\2\2\2}(\3\2\2\2~|\3\2\2\2\177\u0081\t\t\2\2\u0080\177"+
		"\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\b\25\2\2\u0085*\3\2\2\2\u0086\u008a\7\'\2\2"+
		"\u0087\u0089\n\n\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008f\7\17\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3"+
		"\2\2\2\u0090\u0091\7\f\2\2\u0091\u0092\b\26\3\2\u0092,\3\2\2\2\17\2KQ"+
		"U[ajlu|\u0082\u008a\u008e\4\b\2\2\3\26\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}