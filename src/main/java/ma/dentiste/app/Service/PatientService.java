package ma.dentiste.app.Service;

import ma.dentiste.app.entites.AntecedentMedicale;
import ma.dentiste.app.entites.DossierMedicale;
import ma.dentiste.app.entites.Patient;
import org.springframework.stereotype.Service;
import ma.dentiste.app.Respository.PatientRepository;

import java.util.List;

@Service
public class PatientService {
    private static PatientRepository PatientRepository;

    public PatientService(PatientRepository PatientRepository) {
        this.PatientRepository = PatientRepository;
    }

    public static Patient createPatient(Patient Patient) {
        return PatientRepository.save(Patient);
    }

    public static Patient getPatientById(Long id) {
        return PatientRepository.findById(id).get();
    }

    public static Patient updatePatient(Patient Patient) {
        return PatientRepository.save(Patient);
    }

    public static void deletePatient(Long id) {
        PatientRepository.deleteById(id);
    }

    public static List<Patient> getAllPatients() {
        return PatientRepository.findAll();
    }

    public static Patient setDossierMedicale(Patient patient, DossierMedicale dossierMedicale){
        patient.setDossierMedicale(dossierMedicale);
        return PatientRepository.save(patient);
    }




}
