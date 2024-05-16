package ma.dentiste.app.Service;

import ma.dentiste.app.entites.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ma.dentiste.app.Respository.UtilisateurRepository;
import java.util.List;

@Service
public class UtilisateurService {

    private static UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateurById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public static Utilisateur findByNomUtilisateurAndMotDePasse(String nomUtilisateur, String motDePasse) {
        return utilisateurRepository.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse);
    }

}
