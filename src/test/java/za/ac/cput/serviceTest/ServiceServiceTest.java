package za.ac.cput.serviceTest;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Service;
import za.ac.cput.factory.ServiceFactory;
import za.ac.cput.service.ServiceService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ServiceServiceTest {

    @Autowired
    private ServiceService serviceService;

    private static Service service1;
    private static Service service2;

    @Test
    void a_setup() {
        service1 = ServiceFactory.buildService("Haircut", "Buzzcut", "Long", 250);
        assertNotNull(service1);
        System.out.println(service1);

        service2 = ServiceFactory.buildService("Trim", "Nails", "Manicure", 120);
        assertNotNull(service2);
        System.out.println(service2);
    }

    @Test
    void b_create() {
        Service created1 = serviceService.create(service1);
        assertNotNull(created1, "The created service1 should not be null");
        System.out.println("Created service1: " + created1);

        Service created2 = serviceService.create(service2);
        assertNotNull(created2, "The created service2 should not be null");
        System.out.println("Created service2: " + created2);
    }

    @Test
    void c_read() {
        Service read = serviceService.read(service2.getServiceCode());
        assertNotNull(read, "The read service should not be null");
        System.out.println("Read service: " + read);
    }

    @Test
    void d_update() {
        Service updatedService = new Service.Builder()
                .copy(service1)
                //.setMensServiceDescription("Updated Long Description")
                .build();
        Service updated = serviceService.update(updatedService);
        assertNotNull(updated, "The updated service should not be null");
        System.out.println("Updated service: " + updated);
    }

    @Test
    void e_getAll() {
        System.out.println("All services: " + serviceService.getAll());
    }
}
