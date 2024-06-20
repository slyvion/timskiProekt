package timski.proekt.backend.Model.Dto;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserEmailUpdateDto {
    private String email;

    public UserEmailUpdateDto(String email) {

        this.email = email;
    }
}
