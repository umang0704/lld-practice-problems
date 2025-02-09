package org.lld.services.validators;

public class ContactValidators {

    /**
     * Validate contact inputs
     * @param firstName
     * @param lastName
     * @param number
     * @return boolean
     */
    public static boolean areContactInputInValid(String firstName, String lastName, String number) {
        if(firstName == null || firstName.trim().isBlank()){
            System.out.println("First Name should be present.");
            return true;
        }
        if(lastName == null || lastName.trim().isBlank()){
            System.out.println("Last Name should be present.");
            return true;
        }
        if(number == null || number.trim().isBlank() || phoneNumberNotValid(number)){
            System.out.println("Phone number is not valid.");
            return true;
        }
        return false;
    }

    /**
     * Validate phone number
     * @param phoneNumber
     * @return boolean
     */

    public static boolean phoneNumberNotValid(String phoneNumber){
        if(phoneNumber.length() != 10){
            System.out.println("Phone number length is not valid, enter 10 digits only.");
            return true;
        }

        for(char c : phoneNumber.toCharArray()){
            if(!Character.isDigit(c)){
                System.out.println("Only Digits allowed.");
                return true;
            }
        }
        return false;
    }
}
