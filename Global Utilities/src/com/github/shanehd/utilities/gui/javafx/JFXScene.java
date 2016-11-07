package com.github.shanehd.utilities.gui.javafx;

import javafx.beans.NamedArg;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 07/11/2016.
 */
public class JFXScene<T extends Parent> extends Scene {
    private final T layout;

    public JFXScene(@NamedArg("root") T root) {
        super(root);
        layout = root;
    }

    public JFXScene(@NamedArg("root") T root, @NamedArg("width") double width, @NamedArg("height") double height) {
        super(root, width, height);
        layout = root;
    }

    public JFXScene(@NamedArg("root") T root, @NamedArg(value = "fill", defaultValue = "WHITE") Paint fill) {
        super(root, fill);
        layout = root;
    }

    public JFXScene(@NamedArg("root") T root, @NamedArg("width") double width, @NamedArg("height") double height, @NamedArg(value = "fill", defaultValue = "WHITE") Paint fill) {
        super(root, width, height, fill);
        layout = root;
    }

    public JFXScene(@NamedArg("root") T root, @NamedArg(value = "width", defaultValue = "-1") double width, @NamedArg(value = "height", defaultValue = "-1") double height, @NamedArg("depthBuffer") boolean depthBuffer) {
        super(root, width, height, depthBuffer);
        layout = root;
    }

    public JFXScene(@NamedArg("root") T root, @NamedArg(value = "width", defaultValue = "-1") double width, @NamedArg(value = "height", defaultValue = "-1") double height, @NamedArg("depthBuffer") boolean depthBuffer, @NamedArg(value = "antiAliasing", defaultValue = "DISABLED") SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
        layout = root;
    }

    /**
     * @return {@link #getRoot()} cast to the layout Type
     */
    protected T getLayout() {
        return layout;
    }
}
