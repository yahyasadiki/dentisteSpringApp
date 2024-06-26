package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.InterventionMedicaleRepository;
import ma.dentiste.app.entites.Acte;
import ma.dentiste.app.entites.Consultation;
import ma.dentiste.app.entites.InterventionMedicale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterventionMedicalService {

    private static InterventionMedicaleRepository interventionMedicaleRepository;

    public InterventionMedicalService(InterventionMedicaleRepository interventionMedicaleRepository) {
        this.interventionMedicaleRepository = interventionMedicaleRepository;
    }

    public static InterventionMedicale createInterventionMedicale(InterventionMedicale interventionMedicale) {
        return interventionMedicaleRepository.save(interventionMedicale);
    }

    public static InterventionMedicale updateInterventionMedicale(InterventionMedicale interventionMedicale) {
        return interventionMedicaleRepository.save(interventionMedicale);
    }

    public static InterventionMedicale getInterventionMedicaleById(Long id) {
        return interventionMedicaleRepository.findById(id).get();
    }

    public static ArrayList<InterventionMedicale> getAllInterventionMedicales() {
        return (ArrayList<InterventionMedicale>) interventionMedicaleRepository.findAll();
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

    public static InterventionMedicale setConsultation(InterventionMedicale interventionMedicale, Consultation consultation) {
        interventionMedicale.setConsultation(consultation);
        return interventionMedicaleRepository.save(interventionMedicale);
    }

    public static InterventionMedicale setActe(InterventionMedicale interventionMedicale, Acte acte) {
        interventionMedicale.setActe(acte);
        return interventionMedicaleRepository.save(interventionMedicale);
    }

    public List<InterventionMedicale> getInterventionsByConsultation(Consultation consultation) {
        return interventionMedicaleRepository.findByConsultation(consultation);

    }

}