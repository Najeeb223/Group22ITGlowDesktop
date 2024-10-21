package za.ac.cput.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ServiceProvider;
import za.ac.cput.factory.ServiceProviderFactory;
import za.ac.cput.service.ServiceProviderService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ServiceProviderServiceTest {

    @Autowired
    private ServiceProviderService spService;
    private static ServiceProvider sp;

    @Test
    void a_setup() {
        long validServiceCode = 123456789L;

        sp = ServiceProviderFactory.buildSP(
                "123456",
                "Likhona",
                "Nxusani",
                "123456@gmail.org",
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

    @Test
    void b_create() {
        ServiceProvider createdSP = spService.create(sp);
        assertNotNull(createdSP);
        System.out.println(createdSP);
    }

    @Test
    void c_read() {
        ServiceProvider readSP = spService.read(sp.getProviderId());
        assertNotNull(readSP);
        System.out.println(readSP);
    }

    @Test
    void d_update() {
        ServiceProvider newSP = new ServiceProvider.Builder()
                .copy(sp)
                .setFirstName("Ndoda")
                .build();
        ServiceProvider updatedSP = spService.update(newSP);
        assertNotNull(updatedSP);
        System.out.println(updatedSP);
    }

    @Test
    void e_getAll() {
        System.out.println(spService.getAll());
    }
}
