package timski.proekt.backend.Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.Dto.CompanyDto;
import timski.proekt.backend.Service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController { //todo: dodadi reviews??

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String showList(Model model) {
        List<Company> companies = companyService.listAll();
        model.addAttribute("companies", companies);
        return "";
    }


    @GetMapping("/add") // has role admin?
    public String showAdd(Model model) {
        model.addAttribute("company", new Company());
        return "";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Company company = companyService.findById(id);
        model.addAttribute("company", company);
        return "";
    }

    @PostMapping // premesti u logincontroller
    public Company create(@RequestBody CompanyDto companyDto) {
       return companyService.create(
                companyDto.getCompanyName(),
                companyDto.getEmail(),
                companyDto.getPassword(),
                companyDto.getWebsite(),
                companyDto.getDescription(),
                companyDto.getLocation()
        );
    }


    @PutMapping("/{id}/")
    public Company update(@PathVariable Long id,
                          @RequestBody CompanyDto companyDto) {
        return companyService.update(
                id,
                companyDto.getCompanyName(),
                companyDto.getEmail(),
                companyDto.getPassword(),
                companyDto.getWebsite(),
                companyDto.getDescription(),
                companyDto.getLocation()
        );
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        companyService.delete(id);
        return "redirect:/companies";
    }

    //@PostMapping(/{id}/add-reviews)

    //@Postmapping(/{id}/delete-review

    //@Postmapping({id}/show
}
