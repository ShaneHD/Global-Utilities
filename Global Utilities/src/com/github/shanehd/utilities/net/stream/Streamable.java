package com.github.shanehd.utilities.net.stream;

import com.github.shanehd.utilities.ArrayUtils;
import com.github.shanehd.utilities.ImageUtils;
import com.github.shanehd.utilities.StringUtils;
import com.github.shanehd.utilities.i.Stoppable;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * @param <T> The {@link StreamableConfig} that you're using
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 02/10/2016.
 */
public abstract class Streamable<T extends StreamableConfig> implements Stoppable, Runnable {
    public final T configuration;
    private Thread thread;
    private final Logger log;

    public Streamable(T configuration, Logger log) {
        this.configuration = configuration;
        this.log = log;
    }

    /**
     * Start the stream (will send data on a loop until {@link StreamableConfig#getEnabled()}
     *      returns <code>false</code>
     */
    public void start() {
        if(!isSystemValid()) {
            log.warning("Cannot start " + this + ", because the system is invalid.");
            return;
        }

        configuration.setEnabled(true);
        thread = new Thread(this, toString() + " Thread");
        thread.start();
    }

    /**
     * Stop the stream from sending data
     */
    @Override
    public void stop() {
        configuration.setEnabled(false);
        thread = null;
    }

    @Override
    public void run() {
        if(shouldCancel()) {
            log.warning(this + " is about to be force closed, because shouldCancel returns true!");
            configuration.setEnabled(false);
        }

        log.info(this + " started.");

        while(configuration.getEnabled()) {
            tick();

            try {
                Thread.sleep(configuration.getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info(this + " stopped.");
    }

    /**
     * Stream large amounts of data to the server, piece by piece.
     * @param raw The data to send in its entirety
     * @param command The command to send it under
     */
    protected final void sendSplitStream(String raw, String command, String... args) throws IOException {
        //This needs to be split up in order to send the large amount of data
        ArrayList<String> split = StringUtils.splitByLength(raw, 65535 / 2);

        for(String part : split) {
            configuration.getServer().write(command, ArrayUtils.join(new String[]{part}, args));
        }

        //Done sending all parts
        configuration.getServer().write(command, ArrayUtils.join(new String[]{"fin"}, args));
    }

    /**
     * Sets the image to desired size ({@link StreamableConfig#getWidth()}, {@link StreamableConfig#getHeight()})
     *      and encodes it to {@link Base64} for sending
     */
    protected final String encodeAndCompressImage(BufferedImage image) {
        //Set its size to the server requested bounds
        BufferedImage compressed = ImageUtils.resize(image, configuration.getWidth(), configuration.getHeight());
        //Encode it to a sendable string
        String encoded = Base64.getEncoder().encodeToString(ImageUtils.toByteArray(image));

        return encoded;
    }

    /**
     * Should the start of this stream be cancelled?<br/>
     * If so, {@link #stop()} will be called before anything can start streaming.
     */
    protected abstract boolean shouldCancel();

    /**
     * Called every 'tick' of the run loop
     */
    protected abstract void tick();

    /**
     * Is the current computer system able to perform this stream?<br/>
     * Maybe it's running an incompatible OS or perhaps it's missing a required component.
     */
    protected abstract boolean isSystemValid();

    @Override
    public String toString() {
        return "Unknown Stream (override toString to change this)";
    }
}
