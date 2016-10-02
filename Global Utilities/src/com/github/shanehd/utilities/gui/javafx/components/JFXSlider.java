package com.github.shanehd.utilities.gui.javafx.components;

import javafx.scene.control.Slider;

/**
 * Calls {@link #setFocusTraversable(boolean)} with <code>false</code>
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 02/10/2016.
 */
public class JFXSlider extends Slider {
    public JFXSlider() {
        setFocusTraversable(false);
    }

    public JFXSlider(double min, double max, double value) {
        super(min, max, value);
        setFocusTraversable(false);
    }
}
