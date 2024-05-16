package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaisseRepository extends JpaRepository<Caisse, Long> {
}
