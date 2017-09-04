package cn.edu.seu.kse.model;

/**
 * TODO:
 * Created by 张舒韬 on 2017/1/11.
 */
public class CommandLineOutput {
    private int exitValue;
    private String output;
    private String error;

    public CommandLineOutput(String output) {
        this.output = output;
    }

    public CommandLineOutput(String output, String error) {
        this.output = output;
        this.error = error;
    }

    public CommandLineOutput(int exitValue, String output, String error) {
        this.exitValue = exitValue;
        this.output = output;
        this.error = error;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getExitValue() {
        return exitValue;
    }

    public void setExitValue(int exitValue) {
        this.exitValue = exitValue;
    }
}
