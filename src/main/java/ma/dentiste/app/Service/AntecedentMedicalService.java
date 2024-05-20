package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.AntecedentMedicaleRepository;
import ma.dentiste.app.entites.AntecedentMedicale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentMedicalService {
    private static AntecedentMedicaleRepository antecedentMedicaleRepository;

    public AntecedentMedicalService(AntecedentMedicaleRepository antecedentMedicaleRepository) {
        this.antecedentMedicaleRepository = antecedentMedicaleRepository;
    }

    public static AntecedentMedicaleRepository getAntecedentMedicaleRepository() {
        return antecedentMedicaleRepository;
    }

    public static void createAntecedentMedical(AntecedentMedicale antecedentMedicale) {
        antecedentMedicaleRepository.save(antecedentMedicale);
    }

    public static void updateAntecedentMedical(AntecedentMedicale antecedentMedicale) {
        antecedentMedicaleRepository.save(antecedentMedicale);
    }

    public static void deleteAntecedentMedical(AntecedentMedicale antecedentMedicale) {
        antecedentMedicaleRepository.delete(antecedentMedicale);
    }

    public static AntecedentMedicale getAntecedentMedicalById(Long id) {
        return antecedentMedicaleRepository.findById(id).get();
    }

    public static List<AntecedentMedicale> getAllAntecedentMedical() {
        return antecedentMedicaleRepository.findAll();
    }
}
