// Generated from Asp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.syntax.asp;
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
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, LESS=7, 
		GREATER=8, EQUAL=9, NOTEQUAL=10, LESSEQ=11, GREATEREQ=12, COMMA=13, DOT=14, 
		VBAR=15, COLON=16, MINUS=17, NAF=18, IF=19, SOFT_IF=20, AT=21, DECIMAL=22, 
		POSITIVE_INT=23, ZERO=24, STRING=25, PREDICATE=26, VAR=27, WS=28, LINE_COMMENT=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", "LESS", 
		"GREATER", "EQUAL", "NOTEQUAL", "LESSEQ", "GREATEREQ", "COMMA", "DOT", 
		"VBAR", "COLON", "MINUS", "NAF", "IF", "SOFT_IF", "AT", "DECIMAL", "POSITIVE_INT", 
		"ZERO", "STRING", "PREDICATE", "VAR", "WS", "LINE_COMMENT"
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
		case 28:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00b7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3"+
		"\27\5\27p\n\27\3\27\3\27\7\27t\n\27\f\27\16\27w\13\27\3\27\5\27z\n\27"+
		"\3\27\3\27\6\27~\n\27\r\27\16\27\177\3\30\3\30\7\30\u0084\n\30\f\30\16"+
		"\30\u0087\13\30\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u008f\n\32\f\32\16"+
		"\32\u0092\13\32\3\32\3\32\3\33\3\33\7\33\u0098\n\33\f\33\16\33\u009b\13"+
		"\33\3\34\3\34\7\34\u009f\n\34\f\34\16\34\u00a2\13\34\3\35\6\35\u00a5\n"+
		"\35\r\35\16\35\u00a6\3\35\3\35\3\36\3\36\7\36\u00ad\n\36\f\36\16\36\u00b0"+
		"\13\36\3\36\5\36\u00b3\n\36\3\36\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\n\3\2\63;\3\2\62"+
		";\3\2$$\4\2aac|\6\2\62;C\\aac|\3\2C\\\5\2\13\f\17\17\"\"\4\2\f\f\17\17"+
		"\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2"+
		"\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27R\3\2\2"+
		"\2\31U\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2\37\\\3\2\2\2!^\3\2\2\2#`\3\2\2"+
		"\2%b\3\2\2\2\'f\3\2\2\2)i\3\2\2\2+l\3\2\2\2-o\3\2\2\2/\u0081\3\2\2\2\61"+
		"\u0088\3\2\2\2\63\u008a\3\2\2\2\65\u0095\3\2\2\2\67\u009c\3\2\2\29\u00a4"+
		"\3\2\2\2;\u00aa\3\2\2\2=>\7*\2\2>\4\3\2\2\2?@\7+\2\2@\6\3\2\2\2AB\7]\2"+
		"\2B\b\3\2\2\2CD\7_\2\2D\n\3\2\2\2EF\7}\2\2F\f\3\2\2\2GH\7\177\2\2H\16"+
		"\3\2\2\2IJ\7>\2\2J\20\3\2\2\2KL\7@\2\2L\22\3\2\2\2MN\7?\2\2N\24\3\2\2"+
		"\2OP\7#\2\2PQ\7?\2\2Q\26\3\2\2\2RS\7>\2\2ST\7?\2\2T\30\3\2\2\2UV\7@\2"+
		"\2VW\7?\2\2W\32\3\2\2\2XY\7.\2\2Y\34\3\2\2\2Z[\7\60\2\2[\36\3\2\2\2\\"+
		"]\7~\2\2] \3\2\2\2^_\7<\2\2_\"\3\2\2\2`a\7/\2\2a$\3\2\2\2bc\7p\2\2cd\7"+
		"q\2\2de\7v\2\2e&\3\2\2\2fg\7<\2\2gh\7/\2\2h(\3\2\2\2ij\7<\2\2jk\7\u0080"+
		"\2\2k*\3\2\2\2lm\7B\2\2m,\3\2\2\2np\5#\22\2on\3\2\2\2op\3\2\2\2py\3\2"+
		"\2\2qu\t\2\2\2rt\t\3\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vz\3\2"+
		"\2\2wu\3\2\2\2xz\5\61\31\2yq\3\2\2\2yx\3\2\2\2z{\3\2\2\2{}\5\35\17\2|"+
		"~\t\3\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		".\3\2\2\2\u0081\u0085\t\2\2\2\u0082\u0084\t\3\2\2\u0083\u0082\3\2\2\2"+
		"\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\60"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\62\2\2\u0089\62\3\2\2\2\u008a"+
		"\u0090\7$\2\2\u008b\u008c\7^\2\2\u008c\u008f\7$\2\2\u008d\u008f\n\4\2"+
		"\2\u008e\u008b\3\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0094\7$\2\2\u0094\64\3\2\2\2\u0095\u0099\t\5\2\2\u0096\u0098\t\6\2\2"+
		"\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\66\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u00a0\t\7\2\2\u009d"+
		"\u009f\t\6\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a18\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5"+
		"\t\b\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\35\2\2\u00a9:\3\2\2\2"+
		"\u00aa\u00ae\7\'\2\2\u00ab\u00ad\n\t\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b3\7\17\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3"+
		"\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7\f\2\2\u00b5\u00b6\b\36\3\2\u00b6"+
		"<\3\2\2\2\17\2ouy\177\u0085\u008e\u0090\u0099\u00a0\u00a6\u00ae\u00b2"+
		"\4\b\2\2\3\36\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}