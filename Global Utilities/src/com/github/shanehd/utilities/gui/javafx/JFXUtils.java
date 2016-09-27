package com.github.shanehd.utilities.gui.javafx;

import javafx.scene.text.Text;

/**
 * JavaFX Utils
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 27/09/2016.
 */
public class JFXUtils {
    /**
     * Calculates the draw width of a string
     */
    public static double calcDisplayWidth(Object property) {
        Text text = new Text(property.toString());
        return text.getLayoutBounds().getWidth();
    }
}
