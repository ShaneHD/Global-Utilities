package com.github.shanehd.utilities;

import java.util.logging.Logger;

/**
 * Convenient way of storing a {@link java.util.logging.Logger} that can be accessed statically
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 27/11/2016.
 */
public class Log {
    private static Logger logger;

    private Log() {}

    public static Logger get() {
        if(logger == null)
            throw new NullPointerException("Global logger isn't set; use com.github.shanehd.utilities.Log.set");

        return logger;
    }

    public static Logger set(String name) {
        return set(Logger.getLogger(name));
    }

    public static Logger set(Logger logger) {
        Log.logger = logger;
        return logger;
    }
}
