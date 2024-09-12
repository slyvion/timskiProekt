package timski.proekt.backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.Dto.JobPostDto;
import timski.proekt.backend.Model.JobPost;
import timski.proekt.backend.Service.CompanyService;
import timski.proekt.backend.Service.JobPostService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jobposts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @GetMapping("/{id}")
    public JobPost getJobPostById(@PathVariable Long id) {
        return jobPostService.findById(id);
    }

    @GetMapping
    public List<JobPost> showList() {
        List<JobPost> jobPosts = jobPostService.listAll();
        return jobPosts;
    }


    @PostMapping
    public JobPost create(@Valid @RequestBody JobPostDto jobPostDto) {
        return jobPostService.create(
                jobPostDto
        );
    }

    @PutMapping("/{id}/edit")
    public JobPost update(@PathVariable Long id,
                          @Valid  @RequestBody JobPostDto jobPostDto) {


        return jobPostService.update(
                id,
                jobPostDto
        );
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        jobPostService.delete(id);
        return "redirect:/jobposts";
    }
}
