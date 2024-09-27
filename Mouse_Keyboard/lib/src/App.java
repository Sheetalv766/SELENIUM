package selenium;

import java.net.MalformedURLException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.out.println("From App.java");

        // TODO - Uncomment for the Clicks activity
        // Clicks clicks = new Clicks();
        // clicks.run();

        // TODO - Uncomment for Hover and Scroll activity
        // HoverAndScroll hoverAndScroll = new HoverAndScroll();
        // hoverAndScroll.run();

        // TODO - Uncomment for Drag activity
        // Drag drag = new Drag();
        // drag.run();

        // TODO - Uncomment for Keyboard actions activity
        // KeyboardActions keyboardActions = new KeyboardActions();
        // keyboardActions.run();

        // TODO - Uncomment for Multiple key presses activity
        // MultipleKeys multipleKeys = new MultipleKeys();
        // multipleKeys.run();

        // TODO - Uncomment for Autocomplete activity
        AutoComplete autoComplete = new AutoComplete();
        autoComplete.run();
    }
}
