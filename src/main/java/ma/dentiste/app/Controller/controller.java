package ma.dentiste.app.Controller;

import ma.dentiste.app.Service.UtilisateurService;
import ma.dentiste.app.entites.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controller {
    @GetMapping("/index")
    public String hello(){
        return "index";
    }

    @GetMapping("/error")
    public String error(Model model){
        return "error";
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @PostMapping("/login")
    public String loginPost(String nomUtilisateur, String motDePasse, Model model){
        Utilisateur utilisateur = UtilisateurService.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse);

        if(utilisateur != null){
            model.addAttribute("utilisateur", utilisateur);
            return "profile";
        }
        else {
            model.addAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrecte!");
            return "error";        }

    }

    @GetMapping("/profile")
    public String profile(Model model){
        Utilisateur utilisateur = (Utilisateur) model.getAttribute("utilisateur");

        if(utilisateur != null){
            model.addAttribute("utilisateur", utilisateur);
            return "profile";
        }
        else {
            model.addAttribute("errorMessage", "Vous devez vous connecter d'abord!");
            return "error";
        }
    }
}
