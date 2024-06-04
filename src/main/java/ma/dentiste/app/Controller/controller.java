package ma.dentiste.app.Controller;

import ma.dentiste.app.Service.*;
import ma.dentiste.app.entites.*;
import ma.dentiste.app.entites.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@SessionAttributes("dentiste")
public class controller {

    @Autowired
    private DentisteService dentisteService;
    @Autowired
    private SecretaireService secretaireService;
    @Autowired
    private ActeService acteService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DossierMedicalService dossierMedicalService;
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private InterventionMedicalService interventionMedicalService;
    @Autowired
    private FactureService factureService;
    @Autowired
    private SituationFinanciereService SituationFinanciereService;
    @Autowired
    private CaisseService caisseService;

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
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String nomUtilisateur, @RequestParam String motDePasse, Model model) {
        try {
            Dentiste dentiste = dentisteService.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse);
            if (dentiste != null) {
                model.addAttribute("dentiste", dentiste);
                return "profile";
            } else {
                throw new Exception("Nom d'utilisateur ou mot de passe incorrect!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
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
        try {
            Dentiste newDentiste = dentisteService.createDentiste(dentiste);
            if (newDentiste != null) {
                model.addAttribute("dentiste", newDentiste);
                return "profile";
            } else {
                throw new Exception("Failed to register!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute("dentiste") Dentiste dentiste, Model model) {
        try {
            if (dentiste != null) {
                model.addAttribute("dentiste", dentiste);
                return "profile";
            } else {
                throw new Exception("Vous devez vous connecter d'abord!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/editProfile")
    public String editProfile(@ModelAttribute("dentiste") Dentiste dentiste, Model model) {
        try {
            if (dentiste != null) {
                model.addAttribute("dentiste", dentiste);
                List<Specialite> specialites = Arrays.asList(Specialite.values());
                List<StatusEmploye> statusEmployes = Arrays.asList(StatusEmploye.values());

                model.addAttribute("specialites", specialites);
                model.addAttribute("statusEmployes", statusEmployes);
                return "editProfile";
            } else {
                throw new Exception("Vous devez vous connecter d'abord!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/editProfile")
    public String editProfilePost(@ModelAttribute Dentiste dentiste, Model model) {
        try {
            Dentiste updatedDentiste = dentisteService.updateDentiste(dentiste);
            if (updatedDentiste != null) {
                model.addAttribute("dentiste", updatedDentiste);
                return "profile";
            } else {
                throw new Exception("Failed to update profile!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute("dentiste") Dentiste dentiste, Model model) {
        try {
            if (dentiste != null) {
                model.addAttribute("dentiste", null);
                return "login";
            } else {
                throw new Exception("Vous devez vous connecter d'abord!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model) {
        try {
            model.addAttribute("patient", new Patient());
            List<Mutuelle> mutuelles = Arrays.asList(Mutuelle.values());
            model.addAttribute("mutuelles", mutuelles);
            List<GroupeSanguin> groupesSanguins = Arrays.asList(GroupeSanguin.values());
            model.addAttribute("groupesSanguins", groupesSanguins);
            model.addAttribute("dossierMedicales", dossierMedicalService.getDossierMedicalWithouPatient());
            return "addPatient";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/addPatient")
    public String addPatientPost(@ModelAttribute Patient patient, Model model,
                                 @RequestParam Long dossierMedicaleId) {
        try {
            Patient newPatient = patientService.createPatient(patient);
            DossierMedicale dossierMedicale = dossierMedicalService.getDossierMedicalById(dossierMedicaleId);
            patient.setDossierMedicale(dossierMedicale);
            dossierMedicale.setPatient(newPatient);
            if (newPatient != null) {
                dossierMedicalService.setPatient(dossierMedicale, newPatient);
                model.addAttribute("patient", newPatient);
                return "profile";
            } else {
                throw new Exception("Failed to add Patient!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/addDossierMedical")
    public String addDossierMedical(Model model) {
        try {
            model.addAttribute("dossierMedical", new DossierMedicale());
            ArrayList<StatusPaiment> statusPaiments = new ArrayList<>(Arrays.asList(StatusPaiment.values()));
            model.addAttribute("statusPaiments", statusPaiments);
            ArrayList<Dentiste> dentistes = new ArrayList<>(dentisteService.getAllDentistes());
            model.addAttribute("dentistes", dentistes);
            return "addDossierMedical";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/addDossierMedical")
    public String addDossierMedicalPost(@ModelAttribute DossierMedicale dossierMedical, Model model,
                                        @RequestParam String statusPaiment,
                                        @RequestParam String dentiste) {
        try {
            dossierMedical.setStatusPaiment(StatusPaiment.valueOf(statusPaiment));
            dossierMedical.setDentiste(dentisteService.getDentisteById(Long.parseLong(dentiste)));
            DossierMedicale newDossierMedical = dossierMedicalService.createDossierMedical(dossierMedical);
            // create a new situation financiere and add it to the dossier medical
            SituationFinanciere situationFinanciere = new SituationFinanciere();
            situationFinanciere.setMontantGlobalPaye(0.0);
            situationFinanciere.setMontantGlobalRestant(0.0);
            situationFinanciere.setDossierMedicale(newDossierMedical);
            situationFinanciere.setDateCreation(LocalDate.now());
            SituationFinanciere newSituationFinanciere = SituationFinanciereService.createSituationFinanciere(situationFinanciere);
            newDossierMedical.setSituationFinanciere(newSituationFinanciere);

            if (newDossierMedical != null) {
                model.addAttribute("dossierMedical", newDossierMedical);
                return "profile";
            } else {
                throw new Exception("Failed to add DossierMedical!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/addConsultation")
    public String addConsultation(Model model) {
        try {
            model.addAttribute("consultation", new Consultation());
            List<TypeConsultation> typeConsultations = Arrays.asList(TypeConsultation.values());
            model.addAttribute("typeConsultations", typeConsultations);
            List<DossierMedicale> dossierMedicales = dossierMedicalService.getAllDossierMedical();
            model.addAttribute("dossierMedicales", dossierMedicales);
            return "addConsultation";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/addConsultation")
    public String addConsultationPost(@ModelAttribute Consultation consultation, Model model,
                                      @RequestParam Long dossierMedicaleId, @RequestParam Double montantTotal) {
        try {
            DossierMedicale dossierMedicale = dossierMedicalService.getDossierMedicalById(dossierMedicaleId);
            consultation.setDossierMedicale(dossierMedicale);

            SituationFinanciere situationFinanciere = dossierMedicale.getSituationFinanciere();
            situationFinanciere.setMontantGlobalRestant(situationFinanciere.getMontantGlobalRestant() + montantTotal);

            Consultation newConsultation = consultationService.createConsultation(consultation);

            if (newConsultation != null) {
                model.addAttribute("consultation", newConsultation);
                return "profile";
            } else {
                throw new Exception("Failed to add Consultation!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/addIntervention")
    public String addIntervention(Model model) {
        try {
            model.addAttribute("intervention", new InterventionMedicale());
            List<Consultation> consultations = consultationService.getAllConsultations();
            model.addAttribute("consultations", consultations);
            return "addIntervention";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/addIntervention")
    public String addInterventionPost(@ModelAttribute InterventionMedicale intervention, Model model,
                                      @RequestParam Long consultationId) {
        try {
            Consultation consultation = consultationService.getConsultationById(consultationId);
            intervention.setConsultation(consultation);
            InterventionMedicale newIntervention = interventionMedicalService.createInterventionMedicale(intervention);
            if (newIntervention != null) {
                model.addAttribute("intervention", newIntervention);
                return "profile";
            } else {
                throw new Exception("Failed to add Intervention!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/addActe")
    public String addActe(Model model) {
        try {
            ArrayList<InterventionMedicale> interventions = interventionMedicalService.getAllInterventionMedicales();
            model.addAttribute("interventions", interventions);
            ArrayList<CategorieActe> categories = new ArrayList<>(Arrays.asList(CategorieActe.values()));
            model.addAttribute("categories", categories);
            model.addAttribute("acte", new Acte());
            return "addActe";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/addActe")
    public String addActePost(@ModelAttribute Acte acte, Model model,
                              @RequestParam Long interventionId) {
        try {
            Acte newActe = acteService.createActe(acte);
            InterventionMedicale intervention = interventionMedicalService.getInterventionMedicaleById(interventionId);
            acteService.setInterventionMedicale(newActe, intervention);
            interventionMedicalService.setActe(intervention, newActe);

            model.addAttribute("acte", newActe);
            return "profile";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/addFacture")
    public String showAddFactureForm(Model model) {
        try {
            Facture facture = new Facture();
            List<Consultation> consultations = consultationService.getAllConsultations();
            model.addAttribute("consultations", consultations);
            List<TypePaiment> typePaiements = Arrays.asList(TypePaiment.values());
            model.addAttribute("facture", facture);
            model.addAttribute("typePaiements", typePaiements);
            return "addFacture";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/addFacture")
    public String addFacturePost(@ModelAttribute Facture facture, Model model,
                                 @RequestParam Long consultationId) {
        try {
            Consultation consultation = consultationService.getConsultationById(consultationId);
            facture.setConsultation(consultation);
            SituationFinanciere situationFinanciere = consultation.getDossierMedicale().getSituationFinanciere();
            situationFinanciere.setMontantGlobalRestant(situationFinanciere.getMontantGlobalRestant() - facture.getMontantTotal());
            situationFinanciere.setMontantGlobalPaye(situationFinanciere.getMontantGlobalPaye() + facture.getMontantTotal());
            facture.setSituationFinanciere(situationFinanciere);
            facture.setDateFacturation(LocalDate.now());
            Facture newFacture = factureService.createFacture(facture);

            // save in caisse
            Caisse caisse = caisseService.createNewCaisse();



            if (newFacture != null) {
                model.addAttribute("facture", newFacture);
                return "profile";
            } else {
                throw new Exception("Failed to add Facture!");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/patients")
    public String showAllPatients(Model model) {
        try {
            List<Patient> patients = patientService.getAllPatients();
            model.addAttribute("patients", patients);
            return "patients";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/patients/{id}")
    public String deletePatient(@PathVariable Long id, Model model) {
        try {
            patientService.deletePatient(id);
            return "redirect:/patients";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

@GetMapping("patientsDetails/{id}")
public String showPatientDetails(@PathVariable Long id, Model model) {
    try {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);

        List<Consultation> consultations = consultationService.getConsultationsByPatient(patient);
        model.addAttribute("consultations", consultations);

        List<SituationFinanciere> situationFinancieres = new ArrayList<>();
        for (Consultation consultation : consultations) {
            SituationFinanciere situationFinanciere = consultation.getDossierMedicale().getSituationFinanciere();
            situationFinancieres.add(situationFinanciere);
        }
        model.addAttribute("situationFinancieres", situationFinancieres);

        List<InterventionMedicale> allInterventions = new ArrayList<>();
        List<Acte> allActes = new ArrayList<>();
        List<Facture> allFactures = new ArrayList<>();

        for (Consultation consultation : consultations) {
            List<InterventionMedicale> interventions = interventionMedicalService.getInterventionsByConsultation(consultation);
            allInterventions.addAll(interventions);

            for (InterventionMedicale intervention : interventions) {
                Acte acte = acteService.getActeByIntervention(intervention);
                allActes.add(acte);
            }

            List<Facture> factures = factureService.getFacturesByConsultation(consultation);
            allFactures.addAll(factures);
        }

        model.addAttribute("interventions", allInterventions);
        model.addAttribute("actes", allActes);
        model.addAttribute("factures", allFactures);

        // Fetch all the "caisse" records and add them to the model
        List<Caisse> allCaisses = caisseService.getAllCaisses();
        model.addAttribute("caisses", allCaisses);

        return "patientDetails";
    } catch (Exception e) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}

}

