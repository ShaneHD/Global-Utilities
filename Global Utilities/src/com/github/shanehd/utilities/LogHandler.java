package com.github.shanehd.utilities;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 07/07/2016.
 */
public abstract class LogHandler implements ILog {
    abstract void print(String line);
    abstract String format(String type, String line);

    @Override
    public void info(String s) {
        print(format("INFO", s));
    }

    @Override
    public void warning(String s) {
        print(format("WARNING", s));
    }

    @Override
    public void error(String s) {
        print(format("ERROR", s));
    }

    @Override
    public void caught(Throwable t) {
        error("Exception caught: " + t);
        t.printStackTrace();
    }

    @Override
    public void caught(Throwable t, String s) {
        error("Exception caught: " + t + " [" + s + "]");
        t.printStackTrace();
    }

    @Override
    public void fatalError(Throwable t) {
        error("Fatal error: " + t);
        t.printStackTrace();
    }
}
