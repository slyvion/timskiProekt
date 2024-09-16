package timski.proekt.backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private CompanyService companyService;


    @GetMapping("")
    public List<Company> companiesFilter(
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double rating) {

        if ( companyName == null &&
             location == null &&
             rating == null) {
            return companyService.listAll();
        }

        return companyService.companyFilter(companyName, location, rating);
    }

}
