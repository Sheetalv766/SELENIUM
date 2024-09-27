package webElement;

import java.net.MalformedURLException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.out.println("From App.java");

        // TODO - Uncomment for Button web action activity
        // LearnButton learnButton = new LearnButton();
        // learnButton.run();

        // TODO - Uncomment for Edit fields web action activity
        LearnTextBox learnTextBox = new LearnTextBox();
        learnTextBox.run();
    }
}
