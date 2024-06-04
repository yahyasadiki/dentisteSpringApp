package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Acte;
import ma.dentiste.app.entites.InterventionMedicale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeRepository extends JpaRepository<Acte, Long> {
    Acte findByInterventionsMedicales(InterventionMedicale interventionMedicale);
}
