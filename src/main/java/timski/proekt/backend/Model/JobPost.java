package timski.proekt.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue
    private Long Id;

    private String title;

    private String description;

    @ManyToOne
    private Company company;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    private String location;

    public JobPost(String title, String description, Company company, JobType jobType, EmploymentType employmentType, String location) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.jobType = jobType;
        this.employmentType = employmentType;
        this.location = location;
    }
}
