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
		DOT=8, VBAR=9, COLON=10, MINUS=11, NAF=12, IF=13, SOFT_IF=14, AT=15, ANSWERSET_PREFIX=16, 
		OPTIMIZATION_PREFIX=17, DECIMAL=18, POSITIVE_INT=19, ZERO=20, STRING=21, 
		PREDICATE=22, VAR=23, WS=24, LINE_COMMENT=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", "COMMA", 
		"DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "SOFT_IF", "AT", "ANSWERSET_PREFIX", 
		"OPTIMIZATION_PREFIX", "DECIMAL", "POSITIVE_INT", "ZERO", "STRING", "PREDICATE", 
		"VAR", "WS", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "'.'", "'|'", "':'", 
		"'-'", "'not'", "':-'", "':~'", "'@'", "'Answer:'", "'Optimization:'", 
		null, null, "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LSBRACK", "RSBRACK", "LCBRACK", "RCBRACK", 
		"COMMA", "DOT", "VBAR", "COLON", "MINUS", "NAF", "IF", "SOFT_IF", "AT", 
		"ANSWERSET_PREFIX", "OPTIMIZATION_PREFIX", "DECIMAL", "POSITIVE_INT", 
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
		case 24:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00b6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\5"+
		"\23o\n\23\3\23\3\23\7\23s\n\23\f\23\16\23v\13\23\3\23\5\23y\n\23\3\23"+
		"\3\23\6\23}\n\23\r\23\16\23~\3\24\3\24\7\24\u0083\n\24\f\24\16\24\u0086"+
		"\13\24\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u008e\n\26\f\26\16\26\u0091"+
		"\13\26\3\26\3\26\3\27\3\27\7\27\u0097\n\27\f\27\16\27\u009a\13\27\3\30"+
		"\3\30\7\30\u009e\n\30\f\30\16\30\u00a1\13\30\3\31\6\31\u00a4\n\31\r\31"+
		"\16\31\u00a5\3\31\3\31\3\32\3\32\7\32\u00ac\n\32\f\32\16\32\u00af\13\32"+
		"\3\32\5\32\u00b2\n\32\3\32\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\3\2\n\3\2\63;\3\2\62;\3\2$$\4\2aac|\6\2\62;C\\"+
		"aac|\3\2C\\\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u00c1\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\r?"+
		"\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31"+
		"K\3\2\2\2\33O\3\2\2\2\35R\3\2\2\2\37U\3\2\2\2!W\3\2\2\2#_\3\2\2\2%n\3"+
		"\2\2\2\'\u0080\3\2\2\2)\u0087\3\2\2\2+\u0089\3\2\2\2-\u0094\3\2\2\2/\u009b"+
		"\3\2\2\2\61\u00a3\3\2\2\2\63\u00a9\3\2\2\2\65\66\7*\2\2\66\4\3\2\2\2\67"+
		"8\7+\2\28\6\3\2\2\29:\7]\2\2:\b\3\2\2\2;<\7_\2\2<\n\3\2\2\2=>\7}\2\2>"+
		"\f\3\2\2\2?@\7\177\2\2@\16\3\2\2\2AB\7.\2\2B\20\3\2\2\2CD\7\60\2\2D\22"+
		"\3\2\2\2EF\7~\2\2F\24\3\2\2\2GH\7<\2\2H\26\3\2\2\2IJ\7/\2\2J\30\3\2\2"+
		"\2KL\7p\2\2LM\7q\2\2MN\7v\2\2N\32\3\2\2\2OP\7<\2\2PQ\7/\2\2Q\34\3\2\2"+
		"\2RS\7<\2\2ST\7\u0080\2\2T\36\3\2\2\2UV\7B\2\2V \3\2\2\2WX\7C\2\2XY\7"+
		"p\2\2YZ\7u\2\2Z[\7y\2\2[\\\7g\2\2\\]\7t\2\2]^\7<\2\2^\"\3\2\2\2_`\7Q\2"+
		"\2`a\7r\2\2ab\7v\2\2bc\7k\2\2cd\7o\2\2de\7k\2\2ef\7|\2\2fg\7c\2\2gh\7"+
		"v\2\2hi\7k\2\2ij\7q\2\2jk\7p\2\2kl\7<\2\2l$\3\2\2\2mo\5\27\f\2nm\3\2\2"+
		"\2no\3\2\2\2ox\3\2\2\2pt\t\2\2\2qs\t\3\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2"+
		"\2tu\3\2\2\2uy\3\2\2\2vt\3\2\2\2wy\5)\25\2xp\3\2\2\2xw\3\2\2\2yz\3\2\2"+
		"\2z|\5\21\t\2{}\t\3\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"&\3\2\2\2\u0080\u0084\t\2\2\2\u0081\u0083\t\3\2\2\u0082\u0081\3\2\2\2"+
		"\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085(\3"+
		"\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\62\2\2\u0088*\3\2\2\2\u0089\u008f"+
		"\7$\2\2\u008a\u008b\7^\2\2\u008b\u008e\7$\2\2\u008c\u008e\n\4\2\2\u008d"+
		"\u008a\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\7$\2\2\u0093,\3\2\2\2\u0094\u0098\t\5\2\2\u0095\u0097\t\6\2\2\u0096"+
		"\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099.\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009f\t\7\2\2\u009c\u009e"+
		"\t\6\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\60\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\t\b\2"+
		"\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\31\2\2\u00a8\62\3\2\2\2\u00a9"+
		"\u00ad\7\'\2\2\u00aa\u00ac\n\t\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b2\7\17\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\f\2\2\u00b4\u00b5\b\32\3\2\u00b5"+
		"\64\3\2\2\2\17\2ntx~\u0084\u008d\u008f\u0098\u009f\u00a5\u00ad\u00b1\4"+
		"\b\2\2\3\32\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}