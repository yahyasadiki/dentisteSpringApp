package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.DossierMedicaleRepository;
import ma.dentiste.app.entites.Dentiste;
import ma.dentiste.app.entites.Patient;
import org.springframework.stereotype.Service;
import ma.dentiste.app.entites.DossierMedicale;

import java.util.ArrayList;
import java.util.List;

@Service
public class DossierMedicalService {
    private static DossierMedicaleRepository dossierMedicaleRepository;

    public DossierMedicalService(DossierMedicaleRepository dossierMedicaleRepository) {
        this.dossierMedicaleRepository = dossierMedicaleRepository;
    }

    public static DossierMedicale createDossierMedical(DossierMedicale dossierMedicale) {
        return dossierMedicaleRepository.save(dossierMedicale);
    }

    public static DossierMedicale setDentiste(DossierMedicale dossierMedicale, Dentiste dentiste) {
        dossierMedicale.setDentiste(dentiste);
        return dossierMedicaleRepository.save(dossierMedicale);
    }

    public static DossierMedicale setPatient(DossierMedicale dossierMedicale, Patient patient) {
        dossierMedicale.setPatient(patient);
        return dossierMedicaleRepository.save(dossierMedicale);
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

    public static List<DossierMedicale> getAllDossierMedical() {
        List<DossierMedicale> dossierMedicales = new ArrayList<>();
        dossierMedicaleRepository.findAll().forEach(dossierMedicales::add);
        return dossierMedicales;
    }

    public static List<DossierMedicale> getDossierMedicalWithouPatient() {
        List<DossierMedicale> dossierMedicales = new ArrayList<>();
        dossierMedicaleRepository.findAll().forEach(dossierMedicale -> {
            if (dossierMedicale.getPatient() == null) {
                dossierMedicales.add(dossierMedicale);
            }
        });
        return dossierMedicales;
    }
}
