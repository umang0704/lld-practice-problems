package org.interview.clients;

import java.util.logging.Logger;

public class Client {
    private final Logger logger = Logger.getLogger(Client.class.getName());
    /**
     * Execution method
     */
    public void execute() {
        bootServices();
    }

    private void bootServices() {
        logger.info("Starting Transaction System...");
    }
}
