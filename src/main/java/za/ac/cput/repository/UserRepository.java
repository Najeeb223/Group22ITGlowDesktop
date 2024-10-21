package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {



    boolean existsByEmailAndPassword(String email, String password);


    User findByEmail(String email);
}
