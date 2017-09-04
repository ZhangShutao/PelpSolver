package cn.edu.seu.kse.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

public class CommonsExecTest {
    private String readFile(File file) throws IOException {
        StringJoiner input = new StringJoiner("\n");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            input.add(line);
        }
        return input.toString();
    }

    @Test
    public void testCallClingo5() {

    }
}
