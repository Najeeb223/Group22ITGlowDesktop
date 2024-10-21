package za.ac.cput.service;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.ServiceProvider;

public interface SPRepository extends JpaRepository<ServiceProvider, String> {
    ServiceProvider findServiceProviderByProviderId(String spId);
}
