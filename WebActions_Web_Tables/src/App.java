package com.crio.webActions;

import java.net.MalformedURLException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.out.println("From App.java");

        // TODO 1 - Uncomment for Static table subject topper activity
        StaticTableSubjectTopper staticTableSubjectTopper = new StaticTableSubjectTopper();
        staticTableSubjectTopper.run();

        // // TODO 2 - Uncomment for Static table shoe size activity
        // StaticTableShoeSize staticTableShoeSize = new StaticTableShoeSize();
        // staticTableShoeSize.run();
    }
}
