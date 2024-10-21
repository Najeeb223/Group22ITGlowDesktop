package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ServiceProvider;
import za.ac.cput.service.ServiceProviderService;

import java.util.Set;

@RestController
@RequestMapping("/serviceProvider")
public class SPController {
    @Autowired
    private ServiceProviderService providerService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public ServiceProvider create(@RequestBody ServiceProvider sp) {
        return providerService.create(sp);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/read/{id}")
    public ServiceProvider read(@PathVariable String id){
        return providerService.read(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/update")
    public ServiceProvider update(@RequestBody ServiceProvider sp) {
        return providerService.update(sp);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        providerService.delete(id);
    }

    @GetMapping("/getall")
    public Set<ServiceProvider> getall(){
        return providerService.getAll();
    }
}

