package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
