package org.example.logging;

import javax.print.DocFlavor;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

public class ConsoleFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        record.setMessage(String.format("%s%s%s%s",Colors.WHITE_BOLD, record.getMessage(), Colors.RESET, Colors.WHITE));
        record.setSourceClassName(record.getSourceClassName());
        record.setSourceMethodName(String.format("%s%s", getMethodName(record), getColoByLevel(record)));
        return "";
    }

    @Override
    public String formatMessage(LogRecord record){
        return record.getMessage() + record.getLevel();
    }

    private String getColoByLevel(LogRecord record) {
        switch (record.getLevel().getName()){
            case "SEVERE":
                return Colors.RED_BOLD_BRIGHT;
            case "WARNING":
                return Colors.YELLOW_BOLD_BRIGHT;
            case "INFO":
            default:
                return Colors.BLUE_BOLD_BRIGHT;
        }
    }

    private String getMethodName(LogRecord record) {
        return Thread.currentThread().getStackTrace()[9].getMethodName();
    }
}
