package timski.proekt.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = UserRole.User; // Default role set here
    }
}
