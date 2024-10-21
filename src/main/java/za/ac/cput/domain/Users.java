package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
/*
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode

@Builder
@Entity
public class Users {
    @Id
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    public Users(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles    = roles;
    }
}
*/