package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.DossierMedicaleRepository;
import org.springframework.stereotype.Service;
import ma.dentiste.app.entites.DossierMedicale;

import java.util.List;

@Service
public class DossierMedicalService {
    private static DossierMedicaleRepository dossierMedicaleRepository;

    public DossierMedicalService(DossierMedicaleRepository dossierMedicaleRepository) {
        this.dossierMedicaleRepository = dossierMedicaleRepository;
    }

    public static void createDossierMedical(DossierMedicale dossierMedicale) {
        dossierMedicaleRepository.save(dossierMedicale);
    }

    public static void updateDossierMedical(DossierMedicale dossierMedicale) {
        dossierMedicaleRepository.save(dossierMedicale);
    }

    public static void deleteDossierMedical(DossierMedicale dossierMedicale) {
        dossierMedicaleRepository.delete(dossierMedicale);
    }

    public static DossierMedicale getDossierMedicalById(Long id) {
        return dossierMedicaleRepository.findById(id).get();
    }

    public static List<DossierMedicale> getAllDossierMedicals() {
        return dossierMedicaleRepository.findAll();
    }
}
