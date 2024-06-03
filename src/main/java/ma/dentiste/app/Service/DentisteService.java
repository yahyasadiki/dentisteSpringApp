package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.DentisteRepository;
import ma.dentiste.app.entites.Dentiste;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentisteService {
    private static DentisteRepository dentisteRepository;

    public DentisteService(DentisteRepository dentisteRepository) {
        this.dentisteRepository = dentisteRepository;
    }

    public Dentiste createDentiste(Dentiste dentiste) {
        return dentisteRepository.save(dentiste);
    }

    public List<Dentiste> getAllDentistes() {
        return dentisteRepository.findAll();
    }

    public Dentiste getDentisteById(Long id) {
        return dentisteRepository.findById(id).get();
    }

    public Dentiste updateDentiste(Dentiste dentiste) {
        return dentisteRepository.save(dentiste);
    }

    public void deleteDentiste(Long id) {
        dentisteRepository.deleteById(id);
    }

    public static Dentiste findByNomUtilisateurAndMotDePasse(String nomUtilisateur, String motDePasse) {
        if (dentisteRepository.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse) != null) {
            return dentisteRepository.findByNomUtilisateurAndMotDePasse(nomUtilisateur, motDePasse);
        } else {
            return null;
        }
    }

}