package cn.edu.seu.kse.exception;

/**
 * exceptions in translation processes
 *
 * @author 张舒韬
 * @date 2017/3/25
 */
public class TranslateErrorException extends Exception {

    public TranslateErrorException(String message) {
        super("程序翻译出错：" + message);
    }

    public TranslateErrorException(String message, Throwable cause) {
        super("程序翻译出错：" + message, cause);
    }
}
