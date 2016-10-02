package com.github.shanehd.utilities.net.stream;

import com.github.shanehd.utilities.net.Command;
import com.github.shanehd.utilities.net.NetworkHelper;

/**
 * {@link Command} to be used with a {@link Streamable}<br/>
 * This is the client command, used to set stream properties.<br/>
 * To use, add to a {@link com.github.shanehd.utilities.net.PacketHandler}
 * and make a server command to send the relevant properties to this client<br/>
 *
 * @param <T> The exact {@link Streamable} type to use
 * @param <S> The {@link NetworkHelper} (or 'connection to server') that you're using
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 02/10/2016.
 */
public class StreamableCommand<T extends Streamable, S  extends NetworkHelper> implements Command<S> {
    private final T stream;

    public StreamableCommand(T stream) {
        this.stream = stream;
    }

    @Override
    public void handle(S out, String command, String sub, String[] args) throws Exception {
        if(sub.equals("cfg")) {
            String key = args[2];
            String value = args[3];

            stream.configuration.set(key, value);
            return;
        }

        boolean setSize = sub.equals("size");
        boolean enabled = Boolean.parseBoolean(sub);

        if(setSize || enabled) {
            int width = Integer.parseInt(args[2]);
            int height = Integer.parseInt(args[3]);
            long delay = stream.configuration.getDelay();

            try {
                delay = Long.parseLong(args[4]);
            } catch(ArrayIndexOutOfBoundsException e) {} catch(NumberFormatException e) {}

            stream.configuration.setServer(out).setWidth(width).setHeight(height).setDelay(delay);

            if(setSize)
                return;
        }

        //Refresh
        stream.stop();

        if(enabled)
            stream.start();
    }
}