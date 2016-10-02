package com.github.shanehd.utilities.gui.javafx.components;

import javafx.scene.Node;
import javafx.scene.control.ToggleButton;

/**
 * Calls {@link #setFocusTraversable(boolean)} with <code>false</code>
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 02/10/2016.
 */
public class JFXToggleButton extends ToggleButton {
    public JFXToggleButton() {
        setFocusTraversable(false);
    }

    public JFXToggleButton(String text) {
        super(text);
        setFocusTraversable(false);
    }

    public JFXToggleButton(String text, Node graphic) {
        super(text, graphic);
        setFocusTraversable(false);
    }
}
