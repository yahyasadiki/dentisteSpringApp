package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.ActeRepository;
import ma.dentiste.app.entites.Acte;
import ma.dentiste.app.entites.InterventionMedicale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActeService {
    private static ActeRepository acteRepository;

    public ActeService(ActeRepository acteRepository) {
        this.acteRepository = acteRepository;
    }

    public static Acte createActe(Acte acte) {
        return acteRepository.save(acte);
    }

    public static Acte getActeById(Long id) {
        return acteRepository.findById(id).get();
    }

    public void updateActe(Acte acte) {
        acteRepository.save(acte);
    }

    public void deleteActe(Long id) {
        acteRepository.deleteById(id);
    }

    public static ArrayList<Acte> getAllActe() {
        return (ArrayList<Acte>) acteRepository.findAll();
    }


    public static Acte setInterventionMedicale(Acte acte, InterventionMedicale interventionMedicale) {
        List<InterventionMedicale> interventionsMedicales = acte.getInterventionsMedicales();
        if (interventionsMedicales == null) {
            interventionsMedicales = new ArrayList<>();
        }
        interventionsMedicales.add(interventionMedicale);
        acte.setInterventionsMedicales(interventionsMedicales);
        return acteRepository.save(acte);
    }

    public Acte getActeByIntervention(InterventionMedicale interventionMedicale) {
        return acteRepository.findByInterventionsMedicales(interventionMedicale);
    }
}
