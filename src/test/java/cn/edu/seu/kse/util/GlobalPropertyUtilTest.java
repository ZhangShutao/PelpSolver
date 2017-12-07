package cn.edu.seu.kse.util;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/7.
 */
public class GlobalPropertyUtilTest {
    @Test
    public void testProperty() {
        try {
            Properties properties = GlobalPropertyUtil.getProperties();
            System.out.println(properties.getProperty("allowLogging"));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAllowLogging() {
        assertTrue(GlobalPropertyUtil.allowLogging());
    }
}
