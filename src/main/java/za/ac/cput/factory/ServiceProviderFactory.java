package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Service;
import za.ac.cput.domain.ServiceProvider;
import za.ac.cput.util.Helper;

/*
   ServiceProviderFactory class
 */
public class ServiceProviderFactory {

    public static ServiceProvider buildSP(String providerId, String firstName, String lastName,
                                          Contact contact, Service service) {
        if (Helper.isNullOrEmpty(providerId) || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)) {
            return null;
        }
        return new ServiceProvider.Builder()
                .setProviderId(providerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .setService(service)
                .build();
    }

    public static ServiceProvider buildSP(String providerId, String firstName, String lastName,
                                          String email, String mobile, String workTelephone,
                                          long serviceCode, String serviceName, String mensServiceDescription, String womensServiceDescription,
                                          double price) {
        if (Helper.isNullOrEmpty(providerId) || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(mobile)
                || Helper.isNullOrEmpty(workTelephone) || Helper.isNullOrEmpty(serviceName)
                || Helper.isNullOrEmpty(mensServiceDescription) || Helper.isNullOrEmpty(womensServiceDescription)) {
            return null;
        }
        if (!Helper.isValidEmail(email)) {
            return null;
        }
        if (price <= 0) {
            return null;
        }

        Contact contact = new Contact.Builder()
                .setEmail(email)
                .setMobileNumber(mobile)
                .setWorkTelephone(workTelephone)
                .build();

        Service service = new Service.Builder()
                .setServiceCode(serviceCode)
                .setServiceName(serviceName)
                //.setMensServiceDescription(mensServiceDescription)
                .setWomensServiceDescription(womensServiceDescription)
                .setPrice(price)
                .build();

        return new ServiceProvider.Builder()
                .setProviderId(providerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .setService(service)
                .build();
    }
}
