package cn.edu.seu.kse.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.*;

/**
 * 实现对slf4j的logger的封装
 *
 * @author 张舒韬
 * @date 2017/2/7
 */
public class Logger {
    private static org.slf4j.Logger logger;
    private static final String FQCN = Logger.class.getName();
    private static final String LOG_FUNC_NAME = "log";

    static {
        try {
            Enhancer eh = new Enhancer();
            eh.setSuperclass(org.apache.log4j.Logger.class);
            eh.setCallbackType(LogInterceptor.class);
            Class c = eh.createClass();
            Enhancer.registerCallbacks(c, new LogInterceptor[]{new LogInterceptor()});

            @SuppressWarnings("unchecked")
            Constructor<org.apache.log4j.Logger> constructor = c.getConstructor(String.class);
            org.apache.log4j.Logger loggerProxy = constructor.newInstance(Logger.class.getName());

            LoggerRepository loggerRepository = LogManager.getLoggerRepository();
            org.apache.log4j.spi.LoggerFactory lf = ReflectionUtil.getFieldValue(loggerRepository, "defaultFactory");
            Object loggerFactoryProxy = Proxy.newProxyInstance(
                    LoggerFactory.class.getClassLoader(),
                    new Class[]{LoggerFactory.class},
                    new NewLoggerHandler(loggerProxy)
            );

            ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", loggerFactoryProxy);
            logger = org.slf4j.LoggerFactory.getLogger(Logger.class.getName());
            ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", lf);
        } catch (
                IllegalAccessException |
                        NoSuchMethodException |
                        InvocationTargetException |
                        InstantiationException e) {
            throw new RuntimeException("初始化Logger失败", e);
        }
    }

    private static class LogInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            // 只拦截log方法。
            if (objects.length != 4 || !LOG_FUNC_NAME.equals(method.getName())) {
                return methodProxy.invokeSuper(o, objects);
            }
            objects[0] = FQCN;
            return methodProxy.invokeSuper(o, objects);
        }
    }

    private static class NewLoggerHandler implements InvocationHandler {
        private final org.apache.log4j.Logger proxyLogger;

        NewLoggerHandler(org.apache.log4j.Logger proxyLogger) {
            this.proxyLogger = proxyLogger;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return proxyLogger;
        }
    }

    public static void info(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(s);

        }
    }

    public static void info(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(format, o);
        }
    }

    public static void info(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(format, objects);
        }
    }

    public static void info(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(format, throwable);
        }
    }
    
    public static void debug(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(s);
        }
    }

    public static void debug(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(format, o);
        }
    }

    public static void debug(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(format, objects);
        }
    }
    
    public static void debug(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(format, throwable);
        }
    }

    public static void warn(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(s);
        }
    }

    public static void warn(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(format, o);
        }
    }

    public static void warn(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(format, objects);
        }
    }

    public static void warn(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(format, throwable);
        }
    }
    
    public static void error(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(s);
        }
    }

    public static void error(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(format, o);
        }
    }

    public static void error(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(format, objects);
        }
    }

    public static void error(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(format, throwable);
        }
    }
}
