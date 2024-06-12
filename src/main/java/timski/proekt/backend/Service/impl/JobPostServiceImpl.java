package timski.proekt.backend.Service.impl;

import org.springframework.stereotype.Service;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.EmploymentType;
import timski.proekt.backend.Model.JobPost;
import timski.proekt.backend.Model.JobType;
import timski.proekt.backend.Repository.CompanyRepository;
import timski.proekt.backend.Repository.JobPostRepository;
import timski.proekt.backend.Service.JobPostService;
import timski.proekt.backend.exceptions.InvalidJobPostIdException;

import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {

    private final JobPostRepository jobPostRepository;
    private final CompanyRepository companyRepository;

    public JobPostServiceImpl(JobPostRepository jobPostRepository, CompanyRepository companyRepository) {
        this.jobPostRepository = jobPostRepository;
        this.companyRepository = companyRepository;
    }


    @Override
    public List<JobPost> listAll() {
        return jobPostRepository.findAll();
    }

    @Override
    public JobPost findById(Long id) {
        return jobPostRepository.findById(id).orElseThrow(InvalidJobPostIdException::new);
    }

    @Override
    public JobPost create(String title, String description, Company company, JobType jobType, EmploymentType employmentType, String location) {

        JobPost jobPost = new JobPost(title, description, company, jobType, employmentType, location);
        return jobPostRepository.save(jobPost);
    }

    @Override
    public JobPost update(Long id, String title, String description, JobType jobType, EmploymentType employmentType, String location) {
        JobPost jobPost = this.findById(id);

        jobPost.setTitle(title);
        jobPost.setDescription(description);
        jobPost.setJobType(jobType);
        jobPost.setEmploymentType(employmentType);
        jobPost.setLocation(location);
        return jobPostRepository.save(jobPost);
    }

    @Override
    public JobPost delete(Long id) {
        JobPost jobPost = this.findById(id);
        jobPostRepository.delete(jobPost);
        return jobPost;
    }

    @Override
    public List<JobPost> findAllByTitle(String title) {
        return jobPostRepository.findJobPostsByTitle(title);
    }

    @Override
    public List<JobPost> findAllByCompany(Company company) {
        return jobPostRepository.findJobPostsByCompany(company);
    }

    @Override
    public List<JobPost> findAllByDescription(String description) {
        return jobPostRepository.findJobPostsByDescription(description);
    }

    @Override
    public List<JobPost> findAllByLocation(String location) {
        return jobPostRepository.findJobPostsByLocation(location);
    }

    @Override
    public List<JobPost> findAllByJobType(JobType jobType) {
        return jobPostRepository.findJobPostsByJobType(jobType);
    }

    @Override
    public List<JobType> findAllByEmploymentType(EmploymentType employmentType) {
        return jobPostRepository.findJobPostsByEmploymentType(employmentType);
    }
}
