package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Acte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeRepository extends JpaRepository<Acte, Long> {
}
