package com.github.shanehd.utilities.net.stream;

import com.github.shanehd.utilities.net.NetworkHelper;

/**
 * Configuration used by {@link Streamable} to stream mass amounts of data to a {@link NetworkHelper}
 *
 * @param <T> The {@link NetworkHelper} (or 'connection to server') that you're using
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 02/10/2016.
 */
public abstract class StreamableConfig<T extends NetworkHelper> {
    /** Is this stream enabled? */
    private volatile boolean enabled;
    /** Width to scale the stream to */
    private volatile int width;
    /** Height to scale the stream to */
    private volatile int height;
    /** Delay between streaming to the server (0 for none, as fast as possible)*/
    private volatile long delay = 0;
    /** A link to the server */
    private volatile T server;

    protected abstract void setProperty(String key, String value);

    /**
     * Set custom properties
     */
    public final StreamableConfig<T> set(String key, String value) {
        setProperty(key, value);
        return this;
    }

    public StreamableConfig setDelay(long delay) {
        this.delay = delay;
        return this;
    }

    public StreamableConfig setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public long getDelay() {
        return delay;
    }

    public StreamableConfig setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public StreamableConfig setHeight(int height) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public StreamableConfig setServer(T server) {
        this.server = server;
        return this;
    }

    public T getServer() {
        return server;
    }
}