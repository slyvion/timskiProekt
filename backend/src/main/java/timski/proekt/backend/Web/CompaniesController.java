package timski.proekt.backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Company> showList() {
        List<Company> companies = companyService.listAll();
        return companies;
    }

}
