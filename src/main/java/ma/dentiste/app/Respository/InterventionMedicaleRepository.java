package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Consultation;
import ma.dentiste.app.entites.InterventionMedicale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterventionMedicaleRepository extends JpaRepository<InterventionMedicale, Long> {
    List<InterventionMedicale> findByConsultation(Consultation consultation);
}

