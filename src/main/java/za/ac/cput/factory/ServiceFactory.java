package za.ac.cput.factory;

import za.ac.cput.domain.Service;
import za.ac.cput.util.Helper;

/*
Aphelele Zimkhita Joka 218130260
 */
public class ServiceFactory {

    public static Service buildService(String serviceName, String mensServiceDescription,
                                       String womensServiceDescription, double price) {
        // Validate inputs
        if (Helper.isNullOrEmpty(serviceName) || Helper.isNullOrEmpty(mensServiceDescription) ||
                Helper.isNullOrEmpty(womensServiceDescription)) {
            return null;
        }
        if (price < 0) {
            return null;
        }


        return new Service.Builder()
                .setServiceName(serviceName)
                //.setMensServiceDescription(mensServiceDescription)
                .setWomensServiceDescription(womensServiceDescription)
                .setPrice(price)
                .build();
    }


}

