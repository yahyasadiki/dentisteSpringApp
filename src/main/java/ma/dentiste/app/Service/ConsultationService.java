package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.ConsultationRepository;
import ma.dentiste.app.entites.Consultation;
import ma.dentiste.app.entites.DossierMedicale;
import ma.dentiste.app.entites.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {
    public static ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public static Consultation createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public static void updateConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public static void deleteConsultation(Consultation consultation) {
        consultationRepository.delete(consultation);
    }

    public static Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).get();
    }

    public static List<Consultation> getAllConsultations() {
        List<Consultation> consultations = new ArrayList<>();
        consultationRepository.findAll().forEach(consultations::add);
        return consultations;
    }

    public static void setDossierMedicale(Consultation consultation, DossierMedicale dossierMedicale) {
        consultation.setDossierMedicale(dossierMedicale);
        consultationRepository.save(consultation);
    }



    public static List<Consultation> getConsultationsByDossierMedicale(DossierMedicale dossierMedicale) {
        return consultationRepository.findByDossierMedicale(dossierMedicale);
    }

    public List<Consultation> getConsultationsByPatient(Patient patient) {
        List<Consultation> consultations = new ArrayList<>();
        for (Consultation consultation : consultationRepository.findAll()) {
            if (consultation.getDossierMedicale().getPatient().equals(patient)) {
                consultations.add(consultation);
            }
        }
        return consultations;
    }
}
