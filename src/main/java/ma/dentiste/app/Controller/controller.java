package ma.dentiste.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
    @GetMapping("/index")
    public String hello(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
