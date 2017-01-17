package cn.edu.seu.kse.exception;

/**
 * 逻辑程序不可满足
 * Created by 张舒韬 on 2017/1/11.
 */
public class UnsatisfiableException extends Exception {
    public UnsatisfiableException() {
        super();
    }

    public UnsatisfiableException(String message) {
        super("程序不可满足：" + message);
    }

    public UnsatisfiableException(String message, Throwable cause) {
        super("程序不可满足：" + message, cause);
    }
}
