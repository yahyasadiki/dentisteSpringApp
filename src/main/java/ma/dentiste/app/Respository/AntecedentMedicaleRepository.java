package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.AntecedentMedicale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntecedentMedicaleRepository extends JpaRepository<AntecedentMedicale, Long> {
}
