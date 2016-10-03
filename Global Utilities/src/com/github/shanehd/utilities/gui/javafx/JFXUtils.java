package com.github.shanehd.utilities.gui.javafx;

import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;

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

    /**
     * Quick way of showing an {@link Alert} that supports HTML formatting in its <code>content</code><br/>
     * Calls {@link #alert(Alert.AlertType, String, String, double, double, boolean)} with <code>380</code>
     *      width, and <code>256</code> height.
     *
     * @param type The type of alert to show ({@link javafx.scene.control.Alert.AlertType})
     * @param header Text shown above the content
     * @param content The text to display
     * @param wait Should the program wait for this alert to be closed? (should {@link Alert#showAndWait()}
     *             be called instead of {@link Alert#show()}?)
     */
    public static void alert(Alert.AlertType type, String header, String content, boolean wait) {
        alert(type, header, content, 380, 256, wait);
    }

    /**
     * Quick way of showing an {@link Alert} that supports HTML formatting in its <code>content</code>
     *
     * @param type The type of alert to show ({@link javafx.scene.control.Alert.AlertType})
     * @param header Text shown above the content
     * @param content The text to display
     * @param prefWidth Preferred width of the dialog
     * @param prefHeight Preferred height of the dialog
     * @param wait Should the program wait for this alert to be closed? (should {@link Alert#showAndWait()}
     *             be called instead of {@link Alert#show()}?)
     */
    public static void alert(Alert.AlertType type, String header, String content, double prefWidth, double prefHeight, boolean wait) {
        Alert alert = new Alert(type);
        alert.setHeaderText(header);

        Pane pane = alert.getDialogPane();
        pane.setPrefSize(prefWidth, prefHeight);

        WebView html = new WebView();
        html.getEngine().loadContent(content);
        alert.getDialogPane().setContent(html);

        if(wait)
            alert.showAndWait();
        else
            alert.show();
    }
}
