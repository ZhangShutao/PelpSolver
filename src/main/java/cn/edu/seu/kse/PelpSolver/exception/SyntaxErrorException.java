package cn.edu.seu.kse.PelpSolver.exception;

/**
 * 在调用antlr进行语法解析并发现语法错误时抛出的异常
 * Created by 张舒韬 on 2017/1/6.
 */
public class SyntaxErrorException extends Exception{
    public SyntaxErrorException() {
        super();
    }

    public SyntaxErrorException(String msg) {
        super(msg);
    }
}
