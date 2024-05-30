package timski.proekt.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.EmploymentType;
import timski.proekt.backend.Model.JobPost;
import timski.proekt.backend.Model.JobType;

import java.util.List;


public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    List<JobPost> findJobPostsByTitle(String title);
    List<JobPost> findJobPostsByCompany(Company company);
    List<JobPost> findJobPostsByDescription(String description);
    List<JobPost> findJobPostsByLocation(String location);
    List<JobPost> findJobPostsByJobType(JobType jobType);
    List<JobType> findJobPostsByEmploymentType(EmploymentType employmentType);
}
