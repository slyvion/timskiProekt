package timski.proekt.backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.Dto.CompanyDto;
import timski.proekt.backend.Service.CompanyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController { //todo: dodadi reviews??

    @Autowired
    private CompanyService companyService;


    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id,
                           Model model) {
        Company company = companyService.findById(id);
        model.addAttribute("company", company);
        return "";
    }

    @PostMapping // premesti u logincontroller
    public Company create(@Valid @RequestBody CompanyDto companyDto) {
        return companyService.create(
                companyDto
        );
    }


    @PutMapping("/{id}/")
    public Company update(@PathVariable Long id,
                          @Valid @RequestBody CompanyDto companyDto) {
        return companyService.update(
                id,
                companyDto
        );
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        companyService.delete(id);
        return "redirect:/companies";
    }

    //@PostMapping(/{id}/add-reviews)

    //@Postmapping(/{id}/delete-review

    //@Postmapping({id}/showReviews
}