package timski.proekt.backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import timski.proekt.backend.Model.Dto.UserEmailUpdateDto;
import timski.proekt.backend.Model.Dto.UserPasswordUpdateDto;
import timski.proekt.backend.Model.User;
import timski.proekt.backend.Service.UserService;

import javax.validation.Valid;

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

    @PostMapping("/{id}/passwordUpdate")
    public User updatePassword(@PathVariable Long id,
                                 @Valid @RequestBody UserPasswordUpdateDto userDto) {
        return userService.PasswordUpdate(
                id,
                userDto
        );
    }
    @PostMapping("/{id}/emailUpdate")
    public User updateEmail(@PathVariable long id,
                            @Valid @RequestBody UserEmailUpdateDto userDto){
        return userService.EmailUpdate(
          id,
          userDto
        );
    }
}
