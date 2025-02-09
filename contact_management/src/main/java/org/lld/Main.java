package org.lld;

import org.lld.client.ContactManagementClient;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Contact Service...");
        ContactManagementClient client = new ContactManagementClient();
        client.execute();
    }
}