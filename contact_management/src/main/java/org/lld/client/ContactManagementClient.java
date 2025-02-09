package org.lld.client;

import org.lld.repositories.DataRepository;
import org.lld.services.ContactService;
import org.lld.services.SearchService;
import org.lld.services.impl.ContactServiceImpl;
import org.lld.services.impl.SearchServiceImpl;

import java.util.Arrays;

public class ContactManagementClient {
    private DataRepository dataRepository;
    private ContactService contactService;
    private SearchService searchService;


    public void execute(){
        startService();
        String[][] contactInfo = {
//                {"John","Doe","99999999"},
//                {"John","Doe","999999w9"},
//                {"John","Doe","999999923456"},
                {"John","Doe","9999999999"},
                {"John","Dan","9999999991"},
                {"Joe","Kate","9929999999"},
                {"Joey","Kat","9999399999"},
                {"Kristen","D","9949999999"},
                {"Kris","Doe","9999997999"}
        };

        for(String[] contactInput: contactInfo){
            contactService.addContact(contactInput[0],contactInput[1],contactInput[2]);
        }

        System.out.println(dataRepository.getPhoneNumberMapping());
        System.out.println(dataRepository.getTrie());

        String firstNameCriteria[] = {"John" ,"Joe" ,"Kristen" ,"Kris"};
        for(String q : firstNameCriteria){
            System.out.println("Finding by first name like: "+q);
            System.out.println(searchService.findByFirstName(q));
        }

        String lastNameCriteria[] = {"D",
                "Doe",
                "K",
                "Kat"};
        for(String q : lastNameCriteria){
            System.out.println("Finding by last name like: "+q);
            System.out.println(searchService.findByLastName(q));
        }

        String[] phoneNumbersQuery = {"99999999",
                "999999w9",
                "999999923456",
                "9999999999",
                "9999999991",
                "9929999999",
                "9999399999",
                "9949999999",
                "9999997999"};
        for(String q : phoneNumbersQuery){
            System.out.println("Finding by phone : "+q);
            System.out.println(searchService.findByPhoneNumber(q));
        }
        System.out.println("Shutting down contact management service...");

    }

    /**
     * Create Services and Data Layer.
     */
    private void startService() {
        System.out.println("Creating Data Repositories...");
        dataRepository = new DataRepository();
        System.out.println("Creating Services...");
        contactService = new ContactServiceImpl(dataRepository);
        searchService = new SearchServiceImpl(dataRepository);
    }
}
