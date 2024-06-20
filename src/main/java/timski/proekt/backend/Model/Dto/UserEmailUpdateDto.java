package timski.proekt.backend.Model.Dto;


import lombok.Data;


@Data
public class UserDto {
    private String email;
    private String password;

    public UserDto() {
    }
    public UserDto(String email, String password) {

        this.email = email;
        this.password = password;
    }
}
