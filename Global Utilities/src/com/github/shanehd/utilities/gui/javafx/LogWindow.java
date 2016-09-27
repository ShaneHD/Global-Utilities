package com.github.shanehd.utilities.gui.javafx;

import com.github.shanehd.utilities.PCUtils;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.*;

/**
 * Updated {@link com.github.shanehd.utilities.gui.swing.LogWindow} using JavaFX
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 27/09/2016.
 */
public class LogWindow extends Stage {
    private final TextArea text = new TextArea();
    private volatile boolean displayed = false;
    private static LogWindow instance;

    public LogWindow(Logger log) {
        setTitle("Log View");
        text.setEditable(false);

        StackPane layout = new StackPane();
        layout.getChildren().add(text);
        Scene scene = new Scene(layout, (PCUtils.getScreenWidth() / 3) - 15, (PCUtils.getScreenHeight() / 3) - 15);
        setScene(scene);

        setOnCloseRequest(event -> {
            displayed = false;
        });

        log.addHandler(handler);

        instance = this;
    }

    public static LogWindow getInstance() {
        if(instance == null)
            throw new NullPointerException("LogWindow is null. Call the constructor to fix this.");

        return instance;
    }

    /**
     * Toggle the window being displayed
     */
    public void toggle() {
        if(displayed)
            hide();
        else
            show();

        displayed = !displayed;
    }

    private final Handler handler = new Handler() {
        {
            setLevel(Level.ALL);
            setFormatter(new SimpleFormatter());
        }

        @Override
        public void publish(LogRecord record) {
            if(!isLoggable(record))
                return;
            text.appendText(getFormatter().format(record));
        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };
}
