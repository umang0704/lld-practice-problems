package org.lld.services;

import org.lld.models.dto.SearchResults;

public interface SearchService {
    /**
     * Searched by first name prefix,or full name
     * @param firstName
     * @return {@link SearchResults}
     */
    SearchResults findByFirstName(String firstName);
    /**
     * Searched by last name prefix,or full name
     * @param lastName
     * @return {@link SearchResults}
     */
    SearchResults findByLastName(String lastName);
    /**
     * Searched by phone number prefix,or full name
     * @param phoneNumber
     * @return {@link SearchResults}
     */
    SearchResults findByPhoneNumber(String phoneNumber);
}
