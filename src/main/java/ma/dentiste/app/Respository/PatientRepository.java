package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
