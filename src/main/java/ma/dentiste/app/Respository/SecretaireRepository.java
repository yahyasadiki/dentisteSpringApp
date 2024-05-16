package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Secretaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaireRepository extends JpaRepository<Secretaire, Long> {
}
