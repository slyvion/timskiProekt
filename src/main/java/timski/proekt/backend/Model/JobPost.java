package timski.proekt.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobPost {
    private Long Id;

    private String Title;

    private String Description;

    @ManyToOne
    private Company company;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    private String Location;


    public JobPost() {
    }

    public JobPost(String title, String description, Company company, JobType jobType, EmploymentType employmentType, String location) {
        this.Title = title;
        Description = description;
        this.company = company;
        this.jobType = jobType;
        this.employmentType = employmentType;
        Location = location;
    }

}
