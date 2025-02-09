package org.lld.services;


public interface ContactService {
    /**
     * Adds contact to service
     * @param firstName
     * @param lastName
     * @param number
     */
    void addContact(String firstName,String lastName, String number);
}
