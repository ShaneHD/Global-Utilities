package com.github.shanehd.utilities.gui.javafx.components;

import javafx.scene.web.WebView;

/**
 * {@link WebView} that you can append to<br/>
 * Use true with the constructor if you want auto scrolling enabled
 *
 * @see #getWebView()
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 02/10/2016.
 */
public class ConsoleWebView {
    private final WebView view = new WebView();
    /** The content to be loaded */
    private final StringBuilder text = new StringBuilder();

    /**
     * @param autoScroll Scroll to the bottom when appending?
     */
    public ConsoleWebView(boolean autoScroll) {
        if(autoScroll) {
            text.append("<html>");
            text.append("<head>");
            text.append("   <script language=\"javascript\" type=\"text/javascript\">");
            text.append("       function toBottom(){");
            text.append("           window.scrollTo(0, document.body.scrollHeight);");
            text.append("       }");
            text.append("   </script>");
            text.append("</head>");
            text.append("<body onload='toBottom()'>");
            append("", 1);
        }
    }

    /**
     * Append text to the {@link WebView}<br/>
     *
     * @param noNewLineFlag If anything is entered here, the HTML br will not be added
     * @see #getWebView()
     */
    public void append(String text, Object... noNewLineFlag) {
        this.text.append(text + (noNewLineFlag.length == 0 ? "<br>" : ""));
        view.getEngine().loadContent(this.text.toString());
    }

    /**
     * The {@link WebView} instance
     */
    public WebView getWebView() {
        return view;
    }
}
