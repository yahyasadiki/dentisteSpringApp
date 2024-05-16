package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.DossierMedicale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicaleRepository extends JpaRepository<DossierMedicale, Long> {
}
