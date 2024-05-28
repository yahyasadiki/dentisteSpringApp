package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.ConsultationRepository;
import ma.dentiste.app.entites.Consultation;
import ma.dentiste.app.entites.DossierMedicale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public static ArrayList<Consultation> getAllConsultations() {
        return (ArrayList<Consultation>) consultationRepository.findAll();
    }
    // set dossierMedicale

    public static void setDossierMedicale(Consultation consultation, DossierMedicale dossierMedicale) {
        consultation.setDossierMedicale(dossierMedicale);
        consultationRepository.save(consultation);
    }

}
