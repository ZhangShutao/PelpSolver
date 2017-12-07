package cn.edu.seu.kse.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件中定义的全局配置
 *
 * @author 张舒韬
 * @date 2017/2/7
 */
public class GlobalPropertyUtil {
    private static Properties property = null;

    private GlobalPropertyUtil() {
    }

    private static Properties load() throws IOException {
        InputStream input = GlobalPropertyUtil.class.getResourceAsStream("/PelpSolver.properties");
        if (input != null) {
            property = new Properties();
            property.load(input);
        }
        return property;
    }

    public synchronized static Properties getProperties() throws IOException {
        if (null == property && null == load()) {
            throw new IOException("读取配置文件失败。");
        }
        return property;
    }

    public synchronized static boolean allowLogging() {
        try {
            return Boolean.parseBoolean(GlobalPropertyUtil.getProperties().getProperty("allowLogging", "false"));
        } catch (IOException e) {
            return false;
        }
    }

}
