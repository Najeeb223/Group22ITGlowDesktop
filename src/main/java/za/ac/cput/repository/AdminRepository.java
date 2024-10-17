package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
