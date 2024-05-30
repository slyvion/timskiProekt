package timski.proekt.backend.Web;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timski.proekt.backend.Model.Company;

@RestController
@RequestMapping("/auth")
public class LoginController {  // pagename.com/login  /register
//    @PostMapping("/register/company")
//    public Company registerCompany(@RequestBody CompanyDto companyDto) {
//        companyService.create(companyDto);
//    }
}

// auth/register/company
// auth/register/user

// auth/login/company
// auth/login/user