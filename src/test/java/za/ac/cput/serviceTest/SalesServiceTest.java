package za.ac.cput.serviceTest;
/*
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Sales;
import za.ac.cput.factory.SalesFactory;
import za.ac.cput.service.SalesService;



import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class SalesServiceTest {
    @Autowired
    private SalesService salesService;

    private static Sales sales;


    @Test
    void a_setup() {
        sales = SalesFactory.createSales("S234","E234","Relaxer service") ;
        assertNotNull(sales);
        System.out.println(sales);

    }

    @Test
    void b_create() {
        Sales created  = salesService.create(sales);
        assertNotNull(created);
        System.out.println(created);

    }

    @Test
    void c_read() {

        Sales read = salesService.read(sales.getSalesID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Sales newSales = new Sales.Builder().copy(sales).setEmployeeID("E345")
                .build();
        Sales updated= salesService.update(newSales);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    void e_getAll() {
        System.out.println(salesService.getAll());
    }

}*/