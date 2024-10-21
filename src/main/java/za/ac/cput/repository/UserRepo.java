package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {


    User findUserByEmail(String email);
}