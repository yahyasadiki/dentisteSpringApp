package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.ConsultationRepository;
import ma.dentiste.app.entites.Consultation;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {
    public static ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public static void createConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
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

    public static Iterable<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }


}
