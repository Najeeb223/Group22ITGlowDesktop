package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    void testBuildEmployee() {
        Employee e = EmployeeFactory.buildEmployee("218130260", "Aphelele", "Joka", "Aphelele218130260", "apelelejoka@gmail.com", "0843348820", "0216587772");
        assertNotNull(e);
        System.out.println(e.toString());
    }

    @Test
    void testBuildEmployeeWithFail() {
        Employee e = EmployeeFactory.buildEmployee("", "zimkhita", "jay", "sanejay", "zimmy@gmail.com", "0843348820", "0216587772");
        assertNotNull(e);
        System.out.println(e.toString());
    }
}