package com.github.shanehd.utilities.gui.swing;

import com.github.shanehd.utilities.PCUtils;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.*;

/**
 * Display {@link java.util.logging.Logger} content in a {@link javax.swing.JFrame}
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 03/05/2016.
 */
public class LogWindow extends JFrame implements WindowListener {
    private final JTextArea text = new JTextArea();
    private boolean displayed = false;

    public LogWindow(Logger log) {
        text.setEditable(false);
        add(new JScrollPane(text));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(this);
    }

    /**
     * Toggle the window being displayed
     */
    public void toggle() {
        if(!displayed) {
            setSize((PCUtils.getScreenWidth() / 3) - 15, (PCUtils.getScreenHeight() / 3) - 15);
            setLocationRelativeTo(null);
        }

        displayed = !displayed;
        setVisible(displayed);
    }

    private void append(String line) {
        text.append(line);
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

            append(getFormatter().format(record));
        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        displayed = false;
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
