package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserPrincipal;

import za.ac.cput.repository.UserRepo;

@Service

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findUserByEmail(email);
        if(user == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");}
        return new UserPrincipal(user);

    }


}