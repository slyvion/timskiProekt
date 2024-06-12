package timski.proekt.backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import timski.proekt.backend.Model.Dto.UserDto;
import timski.proekt.backend.Model.User;
import timski.proekt.backend.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}/profile")
    public String showProfile(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "";
    }

    @PostMapping("/{id}/edit")
    public User update(@PathVariable Long id,
                       @RequestParam UserDto userDto) {
        return userService.update(
                id,
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
