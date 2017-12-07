package cn.edu.seu.kse.syntax.parser;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.syntax.SyntaxErrorListener;
import cn.edu.seu.kse.syntax.pelp.PelpLexer;
import cn.edu.seu.kse.syntax.pelp.PelpParser;
import cn.edu.seu.kse.syntax.pelp.PelpVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Pelp语法解析工具类
 * Created by 张舒韬 on 2017/1/8.
 */
public class PelpSyntaxParser {
    /**
     * 将输入的文本解析为一个Pelp程序对象
     * @param text 待解析的文本
     * @return 解析所得的PelpProgram对象
     * @throws SyntaxErrorException 文本中存在语法错误
     */
    public static PelpProgram parseProgram(String text) throws SyntaxErrorException {
        PelpLexer lexer = new PelpLexer(new ANTLRInputStream(text));
        CommonTokenStream token = new CommonTokenStream(lexer);
        PelpParser parser = new PelpParser(token);

        // 错误处理
        parser.removeErrorListeners();
        parser.addErrorListener(new SyntaxErrorListener());

        try {
            ParseTree tree = parser.program();
            PelpVisitorImpl visitor = new PelpVisitorImpl();
            return (PelpProgram) visitor.visit(tree);
        } catch (Exception e) {
            if (e.getMessage().contains("语法错误：")) {
                throw new SyntaxErrorException(e.getMessage().substring("语法错误：".length()));
            } else {
                throw e;
            }
        }
    }
}
