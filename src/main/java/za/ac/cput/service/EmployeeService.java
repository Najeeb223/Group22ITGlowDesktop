package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }


    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee read(String employeeID) {
        return this.repository.findById(employeeID).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> getall() {
        return repository.findAll() ;
    }
}
