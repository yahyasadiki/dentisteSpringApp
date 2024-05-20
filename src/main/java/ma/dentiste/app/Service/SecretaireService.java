package ma.dentiste.app.Service;


import ma.dentiste.app.Respository.SecretaireRepository;
import ma.dentiste.app.entites.Secretaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaireService {
    private static SecretaireRepository SecretaireRepository;

    public SecretaireService(SecretaireRepository SecretaireRepository) {
        this.SecretaireRepository = SecretaireRepository;
    }

    public Secretaire createSecretaire(Secretaire Secretaire) {
        return SecretaireRepository.save(Secretaire);
    }

    public List<Secretaire> getAllSecretaires() {
        return SecretaireRepository.findAll();
    }

    public Secretaire getSecretaireById(Long id) {
        return SecretaireRepository.findById(id).get();
    }

    public Secretaire updateSecretaire(Secretaire Secretaire) {
        return SecretaireRepository.save(Secretaire);
    }

    public void deleteSecretaire(Long id) {
        SecretaireRepository.deleteById(id);
    }

    public static Secretaire findByNomUtilisateurAndMotDePasse(String nomUtilisateur, String motDePasse) {
        if (SecretaireRepository.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse) != null) {
            return SecretaireRepository.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse);
        } else {
            return null;
        }
    }

}