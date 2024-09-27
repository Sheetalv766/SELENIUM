package com.crio.seleniumWebActions;

import java.net.MalformedURLException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.out.println("From App.java");

        // TODO1 - Uncomment for Milestone 1 Activity
        // LearnHyperLink learnHyperLink = new LearnHyperLink();
        // learnHyperLink.run();

        // TODO2 - Uncomment for Milestone 2 Activity
        LearnImage learnImage = new LearnImage();
        learnImage.run();
    }
}
