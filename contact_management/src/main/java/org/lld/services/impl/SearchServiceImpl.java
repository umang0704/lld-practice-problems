package org.lld.services.impl;

import org.lld.entities.Contact;
import org.lld.models.dto.SearchResults;
import org.lld.repositories.DataRepository;
import org.lld.services.SearchService;
import org.lld.services.validators.ContactValidators;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SearchServiceImpl implements SearchService {

    private final DataRepository dataRepository;

    public SearchServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * Fetches search results by firstName
     * @param firstName
     * @return {@link SearchResults}
     */
    @Override
    public SearchResults findByFirstName(String firstName) {
        SearchResults searchResults = new SearchResults();
        Collection<Contact> contacts = dataRepository.findByKey(firstName);
        if (contacts == null || contacts.isEmpty()){
            return searchResults;
        }
        searchResults.setCount(contacts.size());
        searchResults.setContacts(contacts);
        return searchResults;
    }

    /**
     * Fetches search results by last name
     * @param lastName
     * @return {@link SearchResults}
     */
    @Override
    public SearchResults findByLastName(String lastName) {
        SearchResults searchResults = new SearchResults();
        Collection<Contact> contacts = dataRepository.findByKey(lastName);
        if (contacts == null || contacts.isEmpty()){
            return searchResults;
        }
        searchResults.setCount(contacts.size());
        searchResults.setContacts(contacts);
        return searchResults;
    }

    /**
     * Fetches search results by phone number
     * @param phoneNumber
     * @return {@link SearchResults}
     */
    @Override
    public SearchResults findByPhoneNumber(String phoneNumber) {
        SearchResults searchResults = new SearchResults();
        if(ContactValidators.phoneNumberNotValid(phoneNumber)){
            return searchResults;
        }
        Contact contact = dataRepository.getContactByPhoneNumber(phoneNumber);
        if(Objects.isNull(contact)){
            return searchResults;
        }
        searchResults.setCount(1);
        searchResults.setContacts(List.of(contact));
        return searchResults;
    }
}
