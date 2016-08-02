package com.github.shanehd.utilities;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 07/07/2016.
 */
public interface ILog {
    void info(String s);
    void warning(String s);
    void error(String s);
    void debug(String s);
    void caught(Throwable t);
    void caught(Throwable t, String s);
    void fatalError(Throwable t);
}
