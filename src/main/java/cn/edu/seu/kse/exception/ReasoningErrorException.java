package cn.edu.seu.kse.exception;

/**
 * 逻辑程序中出现非语法错误，不能推理
 *
 * @author 张舒韬
 * @date 2017/1/11
 */
public class ReasoningErrorException extends Exception {

    public ReasoningErrorException(String message) {
        super("程序推理出错：" + message);
    }

    public ReasoningErrorException(String message, Throwable cause) {
        super("程序推理出错：" + message, cause);
    }
}
