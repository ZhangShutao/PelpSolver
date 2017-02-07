package cn.edu.seu.kse.util;

import org.slf4j.LoggerFactory;

/**
 * 实现对slf4j的logger的封装
 * Created by 张舒韬 on 2017/2/7.
 */
public class Logger {
    private org.slf4j.Logger logger = null;

    public Logger(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(s);
        }
    }

    public void info(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(format, o);
        }
    }

    public void info(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(format, objects);
        }
    }

    public void info(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.info(format, throwable);
        }
    }
    
    public void debug(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(s);
        }
    }

    public void debug(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(format, o);
        }
    }

    public void debug(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(format, objects);
        }
    }
    
    public void debug(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.debug(format, throwable);
        }
    }

    public void warn(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(s);
        }
    }

    public void warn(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(format, o);
        }
    }

    public void warn(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(format, objects);
        }
    }

    public void warn(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.warn(format, throwable);
        }
    }
    
    public void error(String s) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(s);
        }
    }

    public void error(String format, Object o) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(format, o);
        }
    }

    public void error(String format, Object... objects) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(format, objects);
        }
    }

    public void error(String format, Throwable throwable) {
        if (GlobalPropertyUtil.allowLogging()) {
            logger.error(format, throwable);
        }
    }
}
