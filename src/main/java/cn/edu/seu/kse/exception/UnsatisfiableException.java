package cn.edu.seu.kse.exception;

/**
 * 逻辑程序不可满足
 *
 * @author 张舒韬
 * @date 2017/1/11
 */
public class UnsatisfiableException extends Exception {

    public UnsatisfiableException(String message) {
        super("程序不可满足：" + message);
    }

    public UnsatisfiableException(String message, Throwable cause) {
        super("程序不可满足：" + message, cause);
    }
}
