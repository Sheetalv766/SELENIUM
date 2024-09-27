package com.crio.webActions;

import java.net.MalformedURLException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.out.println("From App.java");

        // TODO - Uncomment for Checkbox web action activity
        // LearnCheckbox learnCheckbox = new LearnCheckbox();
        // learnCheckbox.run();

        // TODO - Uncomment for radio button activity
        LearnRadioButton learnRadioButton = new LearnRadioButton();
        learnRadioButton.run();
    }
}
