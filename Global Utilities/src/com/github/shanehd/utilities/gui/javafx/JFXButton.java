package com.github.shanehd.utilities.gui.javafx;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Calls {@link #setFocusTraversable(boolean)} with <code>false</code>
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 02/10/2016.
 */
public class JFXButton extends Button {
    public JFXButton() {
        setFocusTraversable(false);
    }

    public JFXButton(String text) {
        super(text);
        setFocusTraversable(false);
    }

    public JFXButton(String text, Node graphic) {
        super(text, graphic);
        setFocusTraversable(false);
    }
}
