package timski.proekt.backend.Model.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserPasswordUpdateDto {


    private String oldPassword;


    private String newPassword;

    private String confirmPassword;

    public UserPasswordUpdateDto(String oldPassword, String newPassword, String confirmPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }
}
