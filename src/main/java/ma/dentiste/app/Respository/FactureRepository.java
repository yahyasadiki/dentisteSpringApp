package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
