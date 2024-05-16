package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateurAndMotDePasse(String nomUtilisateur, String motDePasse);
}

