package cn.edu.seu.kse.util;

import org.apache.commons.cli.*;
import org.junit.Test;

/**
 * TODO:
 * Created by 张舒韬 on 2017/5/11.
 */
public class CommandLineParserTest {

    @Test
    public void testParser() {
        Options opts = new Options();
        opts.addOption("opt", true, "optimize mode");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(opts, new String[]{"-opt", "0", "test/case0.lp"});
            if (cmd.hasOption("opt")) {
                System.out.println(cmd.getOptionValue("opt"));
            }
            System.out.println(cmd.getArgs()[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
