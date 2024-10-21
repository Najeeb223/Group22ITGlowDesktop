package za.ac.cput.service;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee read(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee login(Employee request) {
        Employee employee = repository.findEmployeeByEmployeeID(request.getEmployeeID());

        if (employee != null && employee.getPassword().equals(request.getPassword())) {
            return new Employee(true, "login successful");
        } else {
            return new Employee(false, "Invalid username or password");
        }
    }
}
 */

