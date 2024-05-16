package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.InterventionMedicale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionMedicaleRepository extends JpaRepository<InterventionMedicale, Long> {
}

