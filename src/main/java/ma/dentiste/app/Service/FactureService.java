package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.FactureRepository;
import ma.dentiste.app.entites.Consultation;
import ma.dentiste.app.entites.Facture;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FactureService {
    private static FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public static Facture createFacture(Facture facture) {

        return factureRepository.save(facture);
    }

    public static void updateFacture(Facture facture) {
        factureRepository.save(facture);
    }

    public static void deleteFacture(Facture facture) {
        factureRepository.delete(facture);
    }

    public static Facture getFactureById(Long id) {
        return factureRepository.findById(id).get();
    }

    public static List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public List<Facture> getFacturesByConsultation(Consultation consultation) {
        return (List<Facture>) factureRepository.findByConsultation(consultation);
    }
}
