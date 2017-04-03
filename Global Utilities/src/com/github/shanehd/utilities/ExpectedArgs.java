package com.github.shanehd.utilities;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 15/01/2017.
 */
public class ExpectedArgs {
    private final HashMap<String, Object> args = new HashMap<String, Object>();

    public ExpectedArgs(String[] args, Object... expected) throws MissingArgumentException {
        if(expected.length % 2 != 0)
            throw new RuntimeException("ExpectedArgs requires id,type");

        try {
            for(int i = 0; i < expected.length; i+= 2) {
                String provided = args[i / 2];
                String id = (String) expected[i];
                Class type = (Class) expected[i + 1];

                this.args.put(id, StringUtils.cast(provided, type));
            }
        } catch(Exception e) {
            throw new MissingArgumentException(e, expected);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String id) {
        return (T) args.get(id);
    }

    public static class MissingArgumentException extends RuntimeException {
        public final Throwable source;

        MissingArgumentException(Throwable source, Object... expected) {
            super("Expected: " + Arrays.asList(expected));
            this.source = source;
        }
    }
}
