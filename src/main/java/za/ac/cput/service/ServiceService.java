package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Service;
import za.ac.cput.repository.ServiceRepository;

import java.util.List;

/*
Aphelele Zimkhita Joka 218130260
 */
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    private ServiceRepository repository;
    @Autowired
    ServiceService(ServiceRepository repository){
        this.repository = repository;
    }
    @Override
    public Service create(Service service) {
        return repository.save(service);
    }

    @Override
    public Service read(Long serviceCode) {
        return this.repository.findById(serviceCode).orElse(null);
    }

    @Override
    public Service update(Service service) {
        return repository.save(service);
    }

    @Override
    public void delete(Long serviceCode) {
        repository.deleteById(serviceCode);

    }
    @Override
    public List<Service> getAll() {
        return repository.findAll();
    }
}