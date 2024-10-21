package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserPrincipal;
import za.ac.cput.repository.UserRepository;

import java.util.List;
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public User read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }


    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    // New method for authentication
    public boolean authenticate(String email, String password) {
        User user = repository.findByEmail(email);
        if (user != null) {
            // Compare raw password from the login request with the hashed password stored in the database
            return encoder.matches(password, user.getPassword());
        }
        return false; // User not found or password mismatch
    }
}
