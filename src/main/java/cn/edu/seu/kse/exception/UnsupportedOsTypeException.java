package cn.edu.seu.kse.exception;

/**
 * TODO:
 * Created by 张舒韬 on 2017/1/11.
 */
public class UnsupportedOsTypeException extends Exception {
    public UnsupportedOsTypeException() {
        super("未知操作系统类型");
    }

    public UnsupportedOsTypeException(String message) {
        super("未知操作系统类型：" + message);
    }
}
