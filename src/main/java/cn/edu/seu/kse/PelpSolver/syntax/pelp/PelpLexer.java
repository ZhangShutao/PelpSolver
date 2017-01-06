// Generated from Pelp.g4 by ANTLR 4.5.3
package cn.edu.seu.kse.PelpSolver.syntax.pelp;
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
		LPAREN=1, RPAREN=2, LSBRACK=3, RSBRACK=4, LCBRACK=5, RCBRACK=6, COMMA=7, 
		DOT=8, VBAR=9, COLON=10, MINUS=11, NAF=12, IF=13, KNOW=14, DECIMAL=15, 
		POSITIVE_INT=16, ZERO=17, STRING=18, PREDICATE=19, VAR=20, WS=21, LINE_COMMENT=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", "COMMA", 
		"DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "KNOW", "DECIMAL", "POSITIVE_INT", 
		"ZERO", "STRING", "PREDICATE", "VAR", "WS", "LINE_COMMENT"
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
		case 21:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u0097\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\5\20P\n\20\3\20\3"+
		"\20\7\20T\n\20\f\20\16\20W\13\20\3\20\5\20Z\n\20\3\20\3\20\6\20^\n\20"+
		"\r\20\16\20_\3\21\3\21\7\21d\n\21\f\21\16\21g\13\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\7\23o\n\23\f\23\16\23r\13\23\3\23\3\23\3\24\3\24\7\24x\n\24"+
		"\f\24\16\24{\13\24\3\25\3\25\7\25\177\n\25\f\25\16\25\u0082\13\25\3\26"+
		"\6\26\u0085\n\26\r\26\16\26\u0086\3\26\3\26\3\27\3\27\7\27\u008d\n\27"+
		"\f\27\16\27\u0090\13\27\3\27\5\27\u0093\n\27\3\27\3\27\3\27\2\2\30\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30\3\2\13\3\2\63;\3\2\62;\3\2$$\4\2C\\c|\7"+
		"\2//\62;C\\aac|\3\2C\\\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17"+
		"\u00a2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3"+
		"/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2"+
		"\2\2\17;\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25A\3\2\2\2\27C\3\2\2\2\31E\3"+
		"\2\2\2\33I\3\2\2\2\35L\3\2\2\2\37O\3\2\2\2!a\3\2\2\2#h\3\2\2\2%j\3\2\2"+
		"\2\'u\3\2\2\2)|\3\2\2\2+\u0084\3\2\2\2-\u008a\3\2\2\2/\60\7*\2\2\60\4"+
		"\3\2\2\2\61\62\7+\2\2\62\6\3\2\2\2\63\64\7]\2\2\64\b\3\2\2\2\65\66\7_"+
		"\2\2\66\n\3\2\2\2\678\7}\2\28\f\3\2\2\29:\7\177\2\2:\16\3\2\2\2;<\7.\2"+
		"\2<\20\3\2\2\2=>\7\60\2\2>\22\3\2\2\2?@\7~\2\2@\24\3\2\2\2AB\7<\2\2B\26"+
		"\3\2\2\2CD\7/\2\2D\30\3\2\2\2EF\7p\2\2FG\7q\2\2GH\7v\2\2H\32\3\2\2\2I"+
		"J\7<\2\2JK\7/\2\2K\34\3\2\2\2LM\7M\2\2M\36\3\2\2\2NP\5\27\f\2ON\3\2\2"+
		"\2OP\3\2\2\2PY\3\2\2\2QU\t\2\2\2RT\t\3\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2"+
		"\2UV\3\2\2\2VZ\3\2\2\2WU\3\2\2\2XZ\5#\22\2YQ\3\2\2\2YX\3\2\2\2Z[\3\2\2"+
		"\2[]\5\21\t\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2` \3"+
		"\2\2\2ae\t\2\2\2bd\t\3\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\""+
		"\3\2\2\2ge\3\2\2\2hi\7\62\2\2i$\3\2\2\2jp\7$\2\2kl\7^\2\2lo\7$\2\2mo\n"+
		"\4\2\2nk\3\2\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3"+
		"\2\2\2st\7$\2\2t&\3\2\2\2uy\t\5\2\2vx\t\6\2\2wv\3\2\2\2x{\3\2\2\2yw\3"+
		"\2\2\2yz\3\2\2\2z(\3\2\2\2{y\3\2\2\2|\u0080\t\7\2\2}\177\t\b\2\2~}\3\2"+
		"\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081*\3\2\2"+
		"\2\u0082\u0080\3\2\2\2\u0083\u0085\t\t\2\2\u0084\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\b\26\2\2\u0089,\3\2\2\2\u008a\u008e\7\'\2\2\u008b\u008d\n\n\2\2"+
		"\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\7\17\2\2"+
		"\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095"+
		"\7\f\2\2\u0095\u0096\b\27\3\2\u0096.\3\2\2\2\17\2OUY_enpy\u0080\u0086"+
		"\u008e\u0092\4\b\2\2\3\27\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}