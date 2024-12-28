package org.lld;

import org.lld.utils.logger.Logger;
import org.lld.utils.logger.LoggerImpl;

public class Main {
    private static Logger logger = new LoggerImpl();

    public static void main(String[] args) {
        logger.info(INIT_LOG);


    }


    //log constants
    private static final String INIT_LOG = "Starting Snake and Ladder Game...";
}