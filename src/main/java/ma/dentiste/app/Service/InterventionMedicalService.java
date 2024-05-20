package ma.dentiste.app.Service;

import org.springframework.stereotype.Service;
import ma.dentiste.app.Respository.InterventionMedicaleRepository;
import ma.dentiste.app.entites.InterventionMedicale;
import java.util.List;

@Service
public class InterventionMedicalService {

    private static InterventionMedicaleRepository interventionMedicaleRepository;

    public InterventionMedicalService(InterventionMedicaleRepository interventionMedicaleRepository) {
        this.interventionMedicaleRepository = interventionMedicaleRepository;
    }

    public InterventionMedicale createInterventionMedicale(InterventionMedicale interventionMedicale) {
        return interventionMedicaleRepository.save(interventionMedicale);
    }

public InterventionMedicale updateInterventionMedicale(InterventionMedicale interventionMedicale) {
        return interventionMedicaleRepository.save(interventionMedicale);
    }

    public InterventionMedicale getInterventionMedicaleById(Long id) {
        return interventionMedicaleRepository.findById(id).get();
    }

    public List<InterventionMedicale> getAllInterventionMedicales() {
        return interventionMedicaleRepository.findAll();
    }

    public void deleteInterventionMedicaleById(Long id) {
        interventionMedicaleRepository.deleteById(id);
    }

    public void deleteInterventionMedicale(InterventionMedicale interventionMedicale) {
        interventionMedicaleRepository.delete(interventionMedicale);
    }

    public void deleteInterventionMedicales(List<InterventionMedicale> interventionMedicales) {
        interventionMedicaleRepository.deleteAll(interventionMedicales);
    }
}
