package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
public class Role {
    @Id
    private String description;

    public Role(String description){
        this.description=description;

    }

    @Override
    public String toString() {
        return "Role{" +
                "description='" + description + '\'' +
                '}';
    }
}
