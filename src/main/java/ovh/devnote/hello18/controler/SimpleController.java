package ovh.devnote.hello18.controler;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @RequestMapping("/hello")
    public String showStaticPage(){
        return "helloworld";
    }

    @RequestMapping("/books/manage")
    public String manageBooks(){
        return "managementMain";
    }

    @RequestMapping("/books/user")
    public String userMain(Model model)
    { String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username",name);
        return "userMain";
    }

    @RequestMapping("/books/admin")
    public String adminRedirect(){
        return "redirect:/books/manage";
    }

}