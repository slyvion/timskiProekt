package timski.proekt.backend.Model.Dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import timski.proekt.backend.Model.UserRole;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private String password;

    public UserDto() {
    }
    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
