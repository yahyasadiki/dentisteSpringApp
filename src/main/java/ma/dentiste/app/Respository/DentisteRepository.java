package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Dentiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentisteRepository extends JpaRepository<Dentiste, Long> {
    Dentiste findByNomUtilisateurAndMotDePasse(String nomUtilisateur, String motDePasse);
}