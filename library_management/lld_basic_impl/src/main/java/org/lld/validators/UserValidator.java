package org.lld.validators;

import org.lld.repo.LibraryRepo;

public class UserValidator {

    /**
     * Check If user with contact exists
     * @param libraryRepo
     * @param contact
     * @return true/false
     */
    public boolean checkIfUSerExistsByContact(LibraryRepo libraryRepo, String contact){
        return libraryRepo
                .getContactToUserMapping()
                .containsKey(contact);
    }

}
