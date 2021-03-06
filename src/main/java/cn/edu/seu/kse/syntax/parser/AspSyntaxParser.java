package cn.edu.seu.kse.syntax.parser;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.BaseObjectModel;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.model.asp.AspRule;
import cn.edu.seu.kse.syntax.SyntaxErrorListener;
import cn.edu.seu.kse.syntax.asp.AspLexer;
import cn.edu.seu.kse.syntax.asp.AspParser;
import cn.edu.seu.kse.syntax.asp.AspVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * ASP程序及回答集的解析接口
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspSyntaxParser {

    public static AspParser getParser(String text) {
        AspLexer lexer = new AspLexer(new ANTLRInputStream(text));
        CommonTokenStream token = new CommonTokenStream(lexer);
        AspParser parser = new AspParser(token);

        // 错误处理
        parser.removeErrorListeners();
        parser.addErrorListener(new SyntaxErrorListener());

        return parser;
    }

    public static BaseObjectModel getVisitedObject(ParseTree tree) {
        AspVisitorImpl visitor = new AspVisitorImpl();
        return (BaseObjectModel) visitor.visit(tree);
    }

    /**
     * 解析ASP程序
     * @param text 待解析的文本
     * @return 解析所得的ASP程序对象
     * @throws SyntaxErrorException 解析时发现语法错误
     */
    public static AspProgram parseProgram(String text) throws SyntaxErrorException {
        AspParser parser = getParser(text);
        try {
            ParseTree tree = parser.program();
            return (AspProgram) getVisitedObject(tree);
        } catch (RuntimeException e) {
            throw new SyntaxErrorException(e.getMessage(), e);
        }
    }

    /**
     * 解析ASP回答集
     * @param text 待解析的文本
     * @return 解析所得的回答集对象
     * @throws SyntaxErrorException 解析时发现语法错误
     */
    public static AnswerSet parseAnswerSet(String text) throws SyntaxErrorException {
        AspParser parser = getParser(text);
        try {
            ParseTree tree = parser.answer_set();
            return (AnswerSet) getVisitedObject(tree);
        } catch (RuntimeException e) {
            throw new SyntaxErrorException(e.getMessage(), e);
        }
    }

    public static AspRule parseRule(String text) throws SyntaxErrorException {
        AspParser parser = getParser(text);
        try {
            ParseTree tree = parser.reasoning_rule();
            return (AspRule) getVisitedObject(tree);
        } catch (RuntimeException e) {
            throw new SyntaxErrorException(e.getMessage(), e);
        }
    }
}
