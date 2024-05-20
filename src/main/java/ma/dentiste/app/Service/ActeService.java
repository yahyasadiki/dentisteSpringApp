package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.ActeRepository;
import ma.dentiste.app.entites.Acte;
import org.springframework.stereotype.Service;

@Service
public class ActeService {
    private static ActeRepository acteRepository;

    public ActeService(ActeRepository acteRepository) {
        this.acteRepository = acteRepository;
    }

    public void createActe(Acte acte) {
        acteRepository.save(acte);
    }

    public static Acte getActeById(Long id) {
        return acteRepository.findById(id).get();
    }

    public void updateActe(Acte acte) {
        acteRepository.save(acte);
    }

    public void deleteActe(Long id) {
        acteRepository.deleteById(id);
    }

    public Iterable<Acte> getAllActe() {
        return acteRepository.findAll();
    }

}
