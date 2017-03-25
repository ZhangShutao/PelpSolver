package cn.edu.seu.kse.exception;

/**
 * TODO:
 * Created by 张舒韬 on 2017/3/25.
 */
public class TranslateErrorException extends Exception {

    public TranslateErrorException() {
    }

    public TranslateErrorException(String message) {
        super("程序翻译出错：" + message);
    }

    public TranslateErrorException(String message, Throwable cause) {
        super("程序翻译出错：" + message, cause);
    }
}
