package com.github.shanehd.utilities.logging;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 07/07/2016.
 */
@Deprecated //TODO remove this
public class DefaultLogHandler extends LogHandler {

    @Override
    public void print(String line) {
        System.out.println(line);
    }

    @Override
    public String format(String type, String line) {
        return type + " - " + line;
    }
}
