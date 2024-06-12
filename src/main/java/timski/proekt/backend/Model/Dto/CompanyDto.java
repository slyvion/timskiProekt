package timski.proekt.backend.Model.Dto;

import lombok.Data;


@Data
public class CompanyDto {
    private String companyName;

    private String email;

    private String password;

    private String website;

    private String description;

    private String location;

    public CompanyDto() {
    }

    public CompanyDto(String companyName, String email, String password, String website, String description, String location) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.website = website;
        this.description = description;
        this.location = location;
    }
}
