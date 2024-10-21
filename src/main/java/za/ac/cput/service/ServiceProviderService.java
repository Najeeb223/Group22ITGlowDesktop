package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ServiceProvider;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceProviderService implements IServiceProviderService{
    private SPRepository repository;
    @Autowired
    ServiceProviderService(SPRepository repository){
        this.repository = repository;
    }

    @Override
    public ServiceProvider create(ServiceProvider sp) {
        return repository.save(sp);
    }

    @Override
    public ServiceProvider read(String spId) {
        return this.repository.findById(spId).orElse(null);
    }

    @Override
    public ServiceProvider update(ServiceProvider sp) {
        return repository.save(sp);
    }

    @Override
    public void delete(String spId) {
        repository.deleteById(spId);
    }

    @Override
    public Set<ServiceProvider> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
