package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.FactureRepository;
import ma.dentiste.app.entites.Facture;
import org.springframework.stereotype.Service;

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

    public static Iterable<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
}
