package za.ac.cput.factory;

import za.ac.cput.domain.Client;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

/*
Likhona Nxusani
 */
public class ClientFactory {
    public static Client buildClient(String clientId, String firstName, String lastName,
                                     Contact contact){
        if (Helper.isNullOrEmpty(clientId) || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName))
            return null;
        return new Client.Builder().setClientId(clientId)
                .setFirstName(firstName).setLastName(lastName)
                .setContact(contact)
                .build();
    }

    public static Client buildClient(String clientId, String firstName, String lastName,
                                     String email, String mobileNumber, String workTelephone){
        if (Helper.isNullOrEmpty(clientId) || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(mobileNumber) || Helper.isNullOrEmpty(workTelephone))
            return null;

        Contact contact = new Contact.Builder().setEmail(email)
                .setMobileNumber(mobileNumber)
                .setWorkTelephone(workTelephone)
                .build();

        return new Client.Builder().setClientId(clientId)
                .setFirstName(firstName).setLastName(lastName)
                .setContact(contact)
                .build();
    }
}
