package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Service;
import za.ac.cput.factory.ServiceFactory;

import static org.junit.jupiter.api.Assertions.*;

class ServiceFactoryTest {

    @Test
    void testBuildService() {
        Service s = ServiceFactory.buildService("Ponytail", "Long hair style for men",
                "Long hair style for women", 152.00);
        assertNotNull(s);
        System.out.println(s.toString());
    }

    @Test
    void testBuildServiceWithFail() {
        Service s = ServiceFactory.buildService("", "Long hair style for men",
                "Long hair style for women", 350.00);
        assertNotNull(s);
        System.out.println(s);
    }
}
