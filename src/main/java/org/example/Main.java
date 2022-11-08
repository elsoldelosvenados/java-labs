package org.example;

import org.example.logging.Logger;


public class Main {
    public static void main(String[] args) {
        Logger.LOGGER.info("This is a just a info message");
        Logger.LOGGER.warning("This is warning");
        Logger.LOGGER.severe("This is a severe error");

        init();
    }

    private static void init() {
        Logger.LOGGER.info("This is another init");
    }
}