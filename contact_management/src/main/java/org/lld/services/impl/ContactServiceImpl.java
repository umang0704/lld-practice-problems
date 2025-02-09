package org.lld.services.impl;

import org.lld.entities.Contact;
import org.lld.repositories.DataRepository;
import org.lld.services.ContactService;
import org.lld.services.validators.ContactValidators;

import java.text.MessageFormat;

/**
 * The type Contact service.
 */
public class ContactServiceImpl implements ContactService {
    private final DataRepository dataRepository;

    /**
     * Instantiates a new Contact service.
     *
     * @param dataRepository the data repository
     */
    public ContactServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        if(ContactValidators.areContactInputInValid(firstName, lastName, phoneNumber)){
            return;
        }

        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);

        if(dataRepository.checkIfPhoneExists(phoneNumber)){
            System.out.println("Contact Already Exists");
        }

        dataRepository.addContactNode(contact.getFirstName(),contact);
        if(!contact.getFirstName().equals(contact.getLastName())) {
            dataRepository.addContactNode(contact.getLastName(), contact);
        }
        dataRepository.addContactMap(contact);

        System.out.println(MessageFormat.format("Contact Added Successfully, {0}",contact));
    }

}
