package org.example.logging;


import java.util.concurrent.ExecutionException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;


public class Logger {

    public static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName()) ;

    static {
        try {
            FileHandler fileHandler = new FileHandler("log.log");
            fileHandler.setFormatter(new SimpleFormatter());
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(consoleHandler);
        }catch (Exception exception){
            LOGGER.severe("It was no possible to init the file for the logs.");
        }
    }
}
