package timski.proekt.backend.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {
    @GetMapping
    public String getHomePage(Model model) {
        return "Home";
    }
}



