
package za.ac.cput.controller;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3004")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("/read/{employeeID}")
    public Employee read(@PathVariable int employeeID) {
        return employeeService.read(employeeID);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestBody Employee request) {
        Employee response = employeeService.login(request);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK); // Return successful login with OK status
        } else {
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED); // Return UNAUTHORIZED if login fails
        }
    }
}

*/




