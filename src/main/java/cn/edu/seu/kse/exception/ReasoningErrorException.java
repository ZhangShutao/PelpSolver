package cn.edu.seu.kse.exception;

/**
 * 逻辑程序中出现非语法错误，不能推理
 * Created by 张舒韬 on 2017/1/11.
 */
public class ReasoningErrorException extends Exception {
    public ReasoningErrorException() {
    }

    public ReasoningErrorException(String message) {
        super("程序推理出错：" + message);
    }

    public ReasoningErrorException(String message, Throwable cause) {
        super("程序推理出错：" + message, cause);
    }
}
