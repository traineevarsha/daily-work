package com.tek.logging;
import java.util.*;
import java.util.logging.*;

public class LoggingExample {

    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {
    	
        logger.info("Application started");
        logger.warning("Low memory warning");
        logger.severe("System failure");

    }
}
