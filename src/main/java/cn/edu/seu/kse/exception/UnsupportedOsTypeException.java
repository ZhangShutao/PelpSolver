package cn.edu.seu.kse.exception;

/**
 * apache failed to find the OS type of this machine or it is not useful
 *
 * @author 张舒韬
 * @date 2017/1/11
 */
public class UnsupportedOsTypeException extends Exception {
    public UnsupportedOsTypeException() {
        super("未知操作系统类型");
    }

    public UnsupportedOsTypeException(String message) {
        super("未知操作系统类型：" + message);
    }
}
