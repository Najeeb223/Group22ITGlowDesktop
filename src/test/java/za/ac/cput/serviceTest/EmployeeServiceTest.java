package za.ac.cput.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    private static Employee employee1;
    private static Employee employee2;

    @Test
    void a_setup(){
        employee1 = EmployeeFactory.buildEmployee("218130260", "Kunge","Nceba","Nceba720101","kungenceba@gmail.com","0843348820","0216587772");
        assertNotNull(employee1);
        System.out.println(employee1);

        employee2 = EmployeeFactory.buildEmployee("369258147", "Aphelele","Joka","Aphelele218130260","apelelejoka@gmail.com","0843340567","0216582311");
        assertNotNull(employee2);
        System.out.println(employee2);
    }
    @Test
    void b_create(){
        Employee created1 = employeeService.create(employee1);
        assertNotNull(created1);
        System.out.println(created1);

        Employee created2 = employeeService.create(employee2);
        assertNotNull(created2);
        System.out.println(created2);
    }
    @Test
    void c_read(){
        Employee read = employeeService.read(employee1.getEmployeeID());
        assertNotNull(read);
        System.out.println(read);

    }
    @Test
    void d_update(){
        Employee newEmployee = new Employee.Builder().copy(employee2).setFirstName("Aphelele Zimmy").build();
        Employee updated= employeeService.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    void e_getall(){
        System.out.println(employeeService.getall());
    }

}