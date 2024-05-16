package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Dentiste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentisteRepository extends JpaRepository<Dentiste, Long> {
}
