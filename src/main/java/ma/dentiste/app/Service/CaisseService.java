package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.CaisseRepository;
import ma.dentiste.app.entites.Caisse;
import org.springframework.stereotype.Service;

@Service
public class CaisseService {
    private static CaisseRepository caisseRepository;

    public CaisseService(CaisseRepository caisseRepository) {
        this.caisseRepository = caisseRepository;
    }

    public void createCaisse(Caisse caisse) {
        caisseRepository.save(caisse);
    }

    public static Caisse getCaisseById(Long id) {
        return caisseRepository.findById(id).get();
    }

    public void updateCaisse(Caisse caisse) {
        caisseRepository.save(caisse);
    }

    public void deleteCaisse(Long id) {
        caisseRepository.deleteById(id);
    }

    public Iterable<Caisse> getAllCaisse() {
        return caisseRepository.findAll();
    }
}
