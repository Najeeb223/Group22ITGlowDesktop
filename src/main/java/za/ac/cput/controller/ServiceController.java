package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Service;
import za.ac.cput.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;


    @PostMapping("/create")
    public Service create(@RequestBody Service service){return serviceService.create(service);}

    @GetMapping("/read/{serviceCode}")
    public Service read(@PathVariable Long serviceCode){return serviceService.read(serviceCode);}

    @PostMapping("/update/{serviceCode}")
    public Service update (@RequestBody Service serviceCode){return serviceService.update(serviceCode);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){serviceService.delete(id);}

    @GetMapping("/getall")
    public List<Service> getAll(){return serviceService.getAll();}

}
