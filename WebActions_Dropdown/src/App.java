package com.crio.webActions;

import java.net.MalformedURLException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.out.println("From App.java");

        // TODO 1 - Uncomment for SingleSelectDropDown activity
        // SingleSelectDropDown singleSelectDropDown = new SingleSelectDropDown();
        // singleSelectDropDown.run();

        // TODO 2 - Uncomment for MultiSelectDropDown activity
        MultiSelectDropDown MultiSelectDropDown= new MultiSelectDropDown();
        MultiSelectDropDown.run();
    }
}
