package ma.dentiste.app.Controller;

import ma.dentiste.app.Service.*;
import ma.dentiste.app.entites.enums.*;
import ma.dentiste.app.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("dentiste") // This annotation is used to store 'dentiste' in session
public class controller {

    @Autowired
    private DentisteService dentisteService;
    private SecretaireService secretaireService;
    private ActeService acteService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DossierMedicalService dossierMedicalService;

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

    @GetMapping("/register")
    public String register(Model model) {
        Dentiste dentiste = new Dentiste();
        model.addAttribute("dentiste", dentiste);
        List<Specialite> specialites = Arrays.asList(Specialite.values());
        List<StatusEmploye> statusEmployes = Arrays.asList(StatusEmploye.values());

        model.addAttribute("specialites", specialites);
        model.addAttribute("statusEmployes", statusEmployes);
        return "register";
    }


    @PostMapping("/register")
    public String registerPost(@ModelAttribute Dentiste dentiste, Model model) {
        Dentiste newDentiste = dentisteService.createDentiste(dentiste);
        if (newDentiste != null) {
            model.addAttribute("dentiste", newDentiste);
            System.out.println(newDentiste.toString());
            return "profile";
        } else {
            model.addAttribute("errorMessage", "Failed to register!");
            return "error";
        }
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute("dentiste") Dentiste dentiste, Model model) {
        if (dentiste != null) {
            model.addAttribute("dentiste", dentiste);
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
            List<Specialite> specialites = Arrays.asList(Specialite.values());
            List<StatusEmploye> statusEmployes = Arrays.asList(StatusEmploye.values());

            model.addAttribute("specialites", specialites);
            model.addAttribute("statusEmployes", statusEmployes);
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


    @GetMapping("/addDossierMedical")
    public String addDossierMedical(Model model) {
        model.addAttribute("dossierMedical", new DossierMedicale());
        ArrayList<StatusPaiment> statusPaiments = new ArrayList<>(Arrays.asList(StatusPaiment.values()));
        model.addAttribute("statusPaiments", statusPaiments);
        ArrayList<Dentiste> dentistes = new ArrayList<>(dentisteService.getAllDentistes());
        model.addAttribute("dentistes", dentistes);
        return "addDossierMedical";
    }

    @PostMapping("/addDossierMedical")
    public String addDossierMedicalPost(@ModelAttribute DossierMedicale dossierMedical, Model model,
                                        @RequestParam String statusPaiment,
                                        @RequestParam String dentiste) {
        dossierMedical.setStatusPaiment(StatusPaiment.valueOf(statusPaiment));
        dossierMedical.setDentiste(dentisteService.getDentisteById(Long.parseLong(dentiste)));

        DossierMedicale newDossierMedical = dossierMedicalService.createDossierMedical(dossierMedical);

        if (newDossierMedical != null) {
            model.addAttribute("dossierMedical", newDossierMedical);
            return "profile";
        } else {
            model.addAttribute("errorMessage", "Failed to add DossierMedical!");
            return "error";
        }
    }


    @GetMapping("/addPatient")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        List<Mutuelle> mutuelles = Arrays.asList(Mutuelle.values());
        model.addAttribute("mutuelles", mutuelles);
        List<GroupeSanguin> groupesSanguins = Arrays.asList(GroupeSanguin.values());
        model.addAttribute("groupesSanguins", groupesSanguins);
        model.addAttribute("dossierMedicales", dossierMedicalService.getDossierMedicalWithouPatient());
        return "addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatientPost(@ModelAttribute Patient patient, Model model,
                                 @RequestParam Long dossierMedicaleId) {
        Patient newPatient = patientService.createPatient(patient);
        patient.setDossierMedicale(dossierMedicalService.getDossierMedicalById(dossierMedicaleId));

        if (newPatient != null) {
            DossierMedicale dossierMedicale = dossierMedicalService.getDossierMedicalById(dossierMedicaleId);
            dossierMedicalService.setPatient(dossierMedicale, newPatient);
            if (dossierMedicale != null) {
            }
            model.addAttribute("patient", newPatient);
            return "profile";
        } else {
            model.addAttribute("errorMessage", "Failed to add Patient!");
            return "error";
        }
    }
}

