package timski.proekt.backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import timski.proekt.backend.Model.Dto.JobPostDto;
import timski.proekt.backend.Model.JobPost;
import timski.proekt.backend.Service.CompanyService;
import timski.proekt.backend.Service.JobPostService;

import java.util.List;

@RestController
@RequestMapping("/jobposts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;
    private CompanyService companyService;

    @GetMapping
    public String showList(Model model) {
        List<JobPost> jobPosts = jobPostService.listAll();
        model.addAttribute("jobPosts", jobPosts);
        return "";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("jobPost", new JobPost());
        return "";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        JobPost jobPost = jobPostService.findById(id);
        model.addAttribute("jobPost", jobPost);
        return "";
    }

    @PostMapping
    public JobPost create(@RequestBody JobPostDto jobPostDto) {
        return jobPostService.create(
                jobPostDto.getTitle(),
                jobPostDto.getDescription(),
                jobPostDto.getCompany(),
                jobPostDto.getJobType(),
                jobPostDto.getEmploymentType(),
                jobPostDto.getLocation()
        );
    }

    @PutMapping("/{id}")
    public JobPost update(@PathVariable Long id, @RequestBody JobPostDto jobPostDto) {
        return jobPostService.update(
                id,
                jobPostDto.getTitle(),
                jobPostDto.getDescription(),
                jobPostDto.getJobType(),
                jobPostDto.getEmploymentType(),
                jobPostDto.getLocation()
        );
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        jobPostService.delete(id);
        return "redirect:/jobposts";
    }
}
