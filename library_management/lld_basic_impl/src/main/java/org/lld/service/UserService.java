package org.lld.service;

import lombok.extern.slf4j.Slf4j;
import org.lld.entities.User;
import org.lld.exceptions.LibraryException;
import org.lld.repo.LibraryRepo;
import org.lld.validators.UserValidator;

import java.text.MessageFormat;
import java.util.Map;

import static java.text.MessageFormat.format;

@Slf4j
public class UserService {

    private UserValidator userValidator;

    public UserService() {
        this.userValidator = new UserValidator();
    }

    /**
     * Create User with Validations
     * @param libraryRepo
     * @param name
     * @param contact
     * @return User Objects
     */
    public User createUser(LibraryRepo libraryRepo,String name, String contact){
        boolean userWithContactExists = userValidator.checkIfUSerExistsByContact(libraryRepo, contact);
        if(userWithContactExists){
            String error = format( "USER_EXISTS_WITH_CONTACT:{0}",contact);
            throw new LibraryException(error);
        }
        User user = new User(name, contact);
        libraryRepo.getUsers().put(user.getId(),user);
        libraryRepo.getContactToUserMapping().put(user.getContact(),user.getId());

        return user;
    }

}
