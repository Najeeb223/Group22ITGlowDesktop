package za.ac.cput.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


   // private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
   /* public User create(@RequestBody User user) {

        return userService.create(user);
    }*/
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public User read(@PathVariable String username) {
        return userService.read(username);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());


    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/update/{id}")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getall")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        boolean authenticated = userService.authenticate(email, password);
        if (authenticated) {
            return ResponseEntity.ok("User authenticated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
    }


}
