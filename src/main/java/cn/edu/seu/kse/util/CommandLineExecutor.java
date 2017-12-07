package cn.edu.seu.kse.util;

import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;

import java.io.IOException;
import java.util.List;

/**
 * call a shell command
 * @author Zhang Shutao
 */
public interface CommandLineExecutor {
    /**
     * call a shell command
     * @param name name of command
     * @param params param list of command
     * @return execute result
     * @throws UnsupportedOsTypeException cannot tell the OS type
     * @throws IOException IO error happened
     */
    CommandLineOutput callShell(String name, List<String> params) throws UnsupportedOsTypeException, IOException;
}
