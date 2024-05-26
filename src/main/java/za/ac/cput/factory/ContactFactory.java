package za.ac.cput.factory;

/*
Aphelele Zimkhita Joka 218130260
 */

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;


public class ContactFactory {

    public static Contact buildContact(String email, String mobileNumber, String workTelephone) {
        if (!Helper.isValidEmail(email) || !Helper.isValidPhoneNumber(mobileNumber) ||
                !Helper.isValidPhoneNumber(workTelephone)) {
            return null;

        }

        return new Contact.Builder()
                .setEmail(email)
                .setMobileNumber(mobileNumber)
                .setWorkTelephone(workTelephone)
                .build();
    }

}




