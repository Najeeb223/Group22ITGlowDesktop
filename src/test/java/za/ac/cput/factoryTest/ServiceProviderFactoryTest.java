package za.ac.cput.factoryTest;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ServiceProvider;
import za.ac.cput.factory.ServiceProviderFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServiceProviderFactoryTest {

    @Test
    void testbuildSP() {
        long validServiceCode = 123456789L;
        ServiceProvider sp = ServiceProviderFactory.buildSP(
                "123456",
                "Likhona",
                "Nxusani",
                "123456@gmail.com",
                "0652347864",
                "0213456723",
                validServiceCode,
                "Barber",
                "Men's Haircuts",
                "Women's Haircuts",
                150.00
        );
        assertNotNull(sp);
        System.out.println(sp);
    }
}
