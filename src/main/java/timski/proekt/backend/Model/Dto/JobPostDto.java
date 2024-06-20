package timski.proekt.backend.Model.Dto;

import lombok.Data;
import timski.proekt.backend.Model.Constants.EmploymentType;
import timski.proekt.backend.Model.Constants.JobType;

@Data
public class JobPostDto {

    private String title;

    private String description;

    private long companyId;

    private JobType jobType;

    private EmploymentType employmentType;

    private String location;


    public JobPostDto() {
    }

    public JobPostDto(String title, String description, long companyId, JobType jobType, EmploymentType employmentType, String location) {
        this.title = title;
        this.description = description;
        this.companyId = companyId;
        this.jobType = jobType;
        this.employmentType = employmentType;
        this.location = location;
    }
}
