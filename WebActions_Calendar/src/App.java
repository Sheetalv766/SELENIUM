package com.crio.webActions;

import java.net.MalformedURLException;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException, ParseException {
        System.out.println("From App.java");

        // TODO 1
        WebElementCalendar webElementCalendar = new WebElementCalendar();
        webElementCalendar.run();
    }
}
