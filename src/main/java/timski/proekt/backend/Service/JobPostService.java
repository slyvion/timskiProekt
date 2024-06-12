package timski.proekt.backend.Service;

import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.EmploymentType;
import timski.proekt.backend.Model.JobPost;
import timski.proekt.backend.Model.JobType;

import java.util.List;

public interface JobPostService {

    List<JobPost> listAll();

    JobPost findById(Long id);

    JobPost create(String title, String description, Company company, JobType jobType, EmploymentType employmentType, String location);

    JobPost update(Long id, String title, String description, JobType jobType, EmploymentType employmentType, String location);

    JobPost delete(Long id);

    List<JobPost> findAllByTitle(String title);

    List<JobPost> findAllByCompany(Company company);

    List<JobPost> findAllByDescription(String description);

    List<JobPost> findAllByLocation(String location);

    List<JobPost> findAllByJobType(JobType jobType);

    List<JobType> findAllByEmploymentType(EmploymentType employmentType);
}