package cn.edu.seu.kse.util;

import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;

import java.io.IOException;
import java.util.List;

public interface CommandLineExecutor {
    CommandLineOutput callShell(String name, List<String> params) throws UnsupportedOsTypeException, IOException;
}
