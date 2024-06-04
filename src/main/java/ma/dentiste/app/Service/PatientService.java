package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.PatientRepository;
import ma.dentiste.app.entites.DossierMedicale;
import ma.dentiste.app.entites.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient setDossierMedicale(Patient patient, DossierMedicale dossierMedicale) {
        patient.setDossierMedicale(dossierMedicale);
        return patientRepository.save(patient);
    }

    public long getAge(Patient patient) {
        return patient.getDateNaissance().getYear();
    }
}
