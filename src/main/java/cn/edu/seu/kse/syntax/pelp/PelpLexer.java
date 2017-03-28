// Generated from Pelp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.syntax.pelp;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PelpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, LESS=7, 
		GREATER=8, EQUAL=9, NOTEQUAL=10, LESSEQ=11, GREATEREQ=12, COMMA=13, DOT=14, 
		VBAR=15, COLON=16, MINUS=17, NAF=18, IF=19, KNOW=20, PROB_LESS=21, DECIMAL=22, 
		POSITIVE_INT=23, ZERO=24, STRING=25, PREDICATE=26, VAR=27, WS=28, LINE_COMMENT=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", "LESS", 
		"GREATER", "EQUAL", "NOTEQUAL", "LESSEQ", "GREATEREQ", "COMMA", "DOT", 
		"VBAR", "COLON", "MINUS", "NAF", "IF", "KNOW", "PROB_LESS", "DECIMAL", 
		"POSITIVE_INT", "ZERO", "STRING", "PREDICATE", "VAR", "WS", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'", "'='", "'!='", 
		"'<='", "'>='", "','", "'.'", "'|'", "':'", "'-'", "'not'", "':-'", "'K'", 
		"'#PL'", null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"LESS", "GREATER", "EQUAL", "NOTEQUAL", "LESSEQ", "GREATEREQ", "COMMA", 
		"DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "KNOW", "PROB_LESS", "DECIMAL", 
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


	public PelpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pelp.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00b8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\27\5\27q\n\27\3\27\3\27\7\27u\n\27\f\27\16\27x\13\27\3\27\5\27{"+
		"\n\27\3\27\3\27\6\27\177\n\27\r\27\16\27\u0080\3\30\3\30\7\30\u0085\n"+
		"\30\f\30\16\30\u0088\13\30\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u0090\n"+
		"\32\f\32\16\32\u0093\13\32\3\32\3\32\3\33\3\33\7\33\u0099\n\33\f\33\16"+
		"\33\u009c\13\33\3\34\3\34\7\34\u00a0\n\34\f\34\16\34\u00a3\13\34\3\35"+
		"\6\35\u00a6\n\35\r\35\16\35\u00a7\3\35\3\35\3\36\3\36\7\36\u00ae\n\36"+
		"\f\36\16\36\u00b1\13\36\3\36\5\36\u00b4\n\36\3\36\3\36\3\36\2\2\37\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2"+
		"\n\3\2\63;\3\2\62;\3\2$$\3\2c|\6\2\62;C\\aac|\3\2C\\\5\2\13\f\17\17\""+
		"\"\4\2\f\f\17\17\u00c3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2"+
		"\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2"+
		"\2\2\27R\3\2\2\2\31U\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2\37\\\3\2\2\2!^\3"+
		"\2\2\2#`\3\2\2\2%b\3\2\2\2\'f\3\2\2\2)i\3\2\2\2+k\3\2\2\2-p\3\2\2\2/\u0082"+
		"\3\2\2\2\61\u0089\3\2\2\2\63\u008b\3\2\2\2\65\u0096\3\2\2\2\67\u009d\3"+
		"\2\2\29\u00a5\3\2\2\2;\u00ab\3\2\2\2=>\7*\2\2>\4\3\2\2\2?@\7+\2\2@\6\3"+
		"\2\2\2AB\7]\2\2B\b\3\2\2\2CD\7_\2\2D\n\3\2\2\2EF\7}\2\2F\f\3\2\2\2GH\7"+
		"\177\2\2H\16\3\2\2\2IJ\7>\2\2J\20\3\2\2\2KL\7@\2\2L\22\3\2\2\2MN\7?\2"+
		"\2N\24\3\2\2\2OP\7#\2\2PQ\7?\2\2Q\26\3\2\2\2RS\7>\2\2ST\7?\2\2T\30\3\2"+
		"\2\2UV\7@\2\2VW\7?\2\2W\32\3\2\2\2XY\7.\2\2Y\34\3\2\2\2Z[\7\60\2\2[\36"+
		"\3\2\2\2\\]\7~\2\2] \3\2\2\2^_\7<\2\2_\"\3\2\2\2`a\7/\2\2a$\3\2\2\2bc"+
		"\7p\2\2cd\7q\2\2de\7v\2\2e&\3\2\2\2fg\7<\2\2gh\7/\2\2h(\3\2\2\2ij\7M\2"+
		"\2j*\3\2\2\2kl\7%\2\2lm\7R\2\2mn\7N\2\2n,\3\2\2\2oq\5#\22\2po\3\2\2\2"+
		"pq\3\2\2\2qz\3\2\2\2rv\t\2\2\2su\t\3\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2"+
		"vw\3\2\2\2w{\3\2\2\2xv\3\2\2\2y{\5\61\31\2zr\3\2\2\2zy\3\2\2\2{|\3\2\2"+
		"\2|~\5\35\17\2}\177\t\3\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081.\3\2\2\2\u0082\u0086\t\2\2\2\u0083\u0085\t"+
		"\3\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\60\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\62\2"+
		"\2\u008a\62\3\2\2\2\u008b\u0091\7$\2\2\u008c\u008d\7^\2\2\u008d\u0090"+
		"\7$\2\2\u008e\u0090\n\4\2\2\u008f\u008c\3\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7$\2\2\u0095\64\3\2\2\2\u0096\u009a"+
		"\t\5\2\2\u0097\u0099\t\6\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\66\3\2\2\2\u009c\u009a\3\2\2"+
		"\2\u009d\u00a1\t\7\2\2\u009e\u00a0\t\6\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a28\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\u00a6\t\b\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\b\35\2\2\u00aa:\3\2\2\2\u00ab\u00af\7\'\2\2\u00ac\u00ae\n\t\2\2"+
		"\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\7\17\2\2"+
		"\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6"+
		"\7\f\2\2\u00b6\u00b7\b\36\3\2\u00b7<\3\2\2\2\17\2pvz\u0080\u0086\u008f"+
		"\u0091\u009a\u00a1\u00a7\u00af\u00b3\4\b\2\2\3\36\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}