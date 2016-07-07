package com.github.shanehd.utilities;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 07/07/2016.
 */
public class DefaultLogHandler extends LogHandler {

    @Override
    void print(String line) {
        System.out.println(line);
    }

    @Override
    String format(String type, String line) {
        return type + " - " + line;
    }
}
