package cn.edu.seu.kse.exception;

/**
 * 在调用antlr进行语法解析并发现语法错误时抛出的异常
 * Created by 张舒韬 on 2017/1/6.
 */
public class SyntaxErrorException extends Exception{
    public SyntaxErrorException() {
        super();
    }

    public SyntaxErrorException(String msg) {
        super("语法错误：" + msg);
    }

    public SyntaxErrorException(String msg, Throwable cause) {
        super("语法错误：" + msg, cause);
    }
}
