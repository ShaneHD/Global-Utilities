package com.github.shanehd.utilities;

import com.github.shanehd.utilities.logging.Log;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


//TODO - Switch to OpenAL
/**
 * Temporary audio system. Needs scrapping and using OAL instead.
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 05/08/2016.
 */
public class Sound extends ArrayList<Clip> {
    private final File dir;

    public Sound(String path) {
        dir = new File(path);

        if(!dir.exists())
            throw new RuntimeException(new FileNotFoundException(this + " doesn't exist."));
    }

    /**
     * Play the sound once
     */
    public void play() {
        start(0);
    }

    /**
     * Loop for a set amount of times
     * @param times Amount of loops
     */
    public void loop(int times) {
        times-= 1;

        if(times == -1)
            Log.warning("Loop started for " + this + ", but it is infinite. Use loop() method with no arguments for this.");

        start(times);
    }

    /**
     * Loops the sound for infinity until stopped
     */
    public void loop() {
        start(-1);
    }

    private void start(int times) {
        stop();

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(dir));

            if(times != 0)
                clip.loop(times);
            else
                clip.start();

            add(clip);
        } catch(Exception e) {
            Log.caught(e, "When starting " + this);
        }
    }

    public void setVolume(float gain) {
        for(Clip clip : this) {
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(gain);
        }
    }

    /**
     * Stop the sound
     */
    public void stop() {
        //forEach(Clip::stop);

        for(Clip clip : this) {
            clip.stop();
        }

        clear();
    }

    @Override
    public String toString() {
        return "GameSound " + StringUtils.quote(dir);
    }
}