package timski.proekt.backend.Model.Dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.EmploymentType;
import timski.proekt.backend.Model.JobType;

@Getter
@Setter
public class JobPostDto {
    private String Title;

    private String Description;

    @ManyToOne
    private Company company;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    private String Location;


    public JobPostDto() {
    }

    public JobPostDto(String title, String description, Company company, JobType jobType, EmploymentType employmentType, String location) {
        this.Title = title;
        Description = description;
        this.company = company;
        this.jobType = jobType;
        this.employmentType = employmentType;
        Location = location;
    }
}
