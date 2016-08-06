package com.github.shanehd.utilities.logging;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 07/07/2016.
 */
public final class Log {
    private static LogHandler handler = new DefaultLogHandler();

    public static void setHandler(LogHandler handler) {
        Log.handler = handler;
    }

    public static void info(String s) {
        handler.info(s);
    }

    public static void warning(String s) {
        handler.warning(s);
    }

    public static void error(String s) {
        handler.error(s);
    }

    public static void debug(String s) {
        handler.debug(s);
    }

    public static void caught(Throwable t) {
        handler.caught(t);
    }

    public static void caught(Throwable t, String s) {
        handler.caught(t, s);
    }

    public static void fatalError(Throwable t) {
        handler.fatalError(t);
    }
}
