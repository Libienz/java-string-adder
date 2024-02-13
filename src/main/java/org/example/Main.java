package org.example;

import org.example.config.Config;

public class Main {

    public static void main(String[] args) {
        new Config()
                .stringAdderController()
                .run();
    }
}