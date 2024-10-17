package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.AdminDetails;
import za.ac.cput.repository.AdminRepository;


@Service
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = repository.findByUsername(username);

        if (admin == null){
               throw new UsernameNotFoundException("Username not found");
        }

        return new AdminDetails(admin);  // Return AdminDetails based on the fetched admin
    }

    // Method to create a new admin
    public Admin createAdmin(String username, String password) { //, String roles
        Admin admin = Admin.builder()
                .username(username)
                .password(password) // Ensure this is hashed in a real application
               // .roles(roles)
                .build();

        return repository.save(admin); // Save the new admin to the database
    }
}
