package ma.dentiste.app.Controller;

import ma.dentiste.app.Service.ActeService;
import ma.dentiste.app.Service.DentisteService;
import ma.dentiste.app.Service.SecretaireService;
import ma.dentiste.app.entites.Dentiste;
import ma.dentiste.app.entites.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("dentiste") // This annotation is used to store 'dentiste' in session
public class controller {

    @Autowired
    private DentisteService dentisteService;
    private SecretaireService secretaireService;
    private ActeService acteService;

    @GetMapping("/index")
    public String hello() {
        return "index";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String nomUtilisateur, @RequestParam String motDePasse, Model model) {
        Dentiste dentiste = dentisteService.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse);

        if (dentiste != null) {
            model.addAttribute("dentiste", dentiste); // Add dentiste to the model
            return "profile";
        } else {
            model.addAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect!");
            return "error";
        }
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute("dentiste") Dentiste dentiste, Model model) {
        if (dentiste != null) {
            return "profile";
        } else {
            model.addAttribute("errorMessage", "Vous devez vous connecter d'abord!");
            return "error";
        }
    }

    @GetMapping("/editProfile")
    public String editProfile(@ModelAttribute("dentiste") Dentiste dentiste, Model model) {
        if (dentiste != null) {
            model.addAttribute("dentiste", dentiste);
            return "editProfile";
        } else {
            model.addAttribute("errorMessage", "Vous devez vous connecter d'abord!");
            return "error";
        }
    }

    @PostMapping("/editProfile")
    public String editProfilePost(@ModelAttribute Dentiste dentiste, Model model) {
        Dentiste updatedDentiste = dentisteService.updateDentiste(dentiste);
        if (updatedDentiste != null) {
            model.addAttribute("dentiste", updatedDentiste);
            return "profile";
        } else {
            model.addAttribute("errorMessage", "Failed to update profile!");
            return "error";
        }
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute("dentiste") Dentiste dentiste, Model model) {
        if (dentiste != null) {
            model.addAttribute("dentiste", null);
            return "Login";
        } else {
            model.addAttribute("errorMessage", "Vous devez vous connecter d'abord!");
            return "error";
        }
    }

    @GetMapping("/CRUDdentiste")
    public String CRUDdentiste(Model model) {
        model.addAttribute("actes", acteService.getAllActe());
        return "CRUDdentiste";
    }


}
