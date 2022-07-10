package ovh.devnote.hello18.controler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.hello18.entity.Authority;
import ovh.devnote.hello18.entity.User;
import ovh.devnote.hello18.services.UserService;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/register"})
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        String validator = validate(user);

        if (!validator.isEmpty()) {
            model.addAttribute("validator", validator);
            return "register";
        }
        user.getAuthorities().add(new Authority(user, "ROLE_USER"));
        System.out.println(user.getUsername());
        userService.saveUser(user);
        return "redirect:/login";
    }

    private String validate(User user) {
        User newUser = userService.getUser(user.getUsername());
        if (newUser.getUsername() != null) {
            return "użytkownik o takiej nazwie istnieje";
        } else if (user.getUsername().isEmpty() || user.getPassword().isEmpty())
        {
            return "wypełnij wszystkie pola";
        }
        return "";
    }
}
