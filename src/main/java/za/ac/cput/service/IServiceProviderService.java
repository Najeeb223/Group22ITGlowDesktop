package za.ac.cput.service;

import za.ac.cput.domain.ServiceProvider;

import java.util.Set;

public interface IServiceProviderService extends IService<ServiceProvider, String>{
    Set<ServiceProvider> getAll();
}
