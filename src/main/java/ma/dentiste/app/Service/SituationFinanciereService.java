package ma.dentiste.app.Service;

import ma.dentiste.app.Respository.SituationFinanciereRepository;
import ma.dentiste.app.entites.SituationFinanciere;
import org.springframework.stereotype.Service;


@Service
public class SituationFinanciereService {
    private static SituationFinanciereRepository situationFinanciereRepository;

    public SituationFinanciereService(SituationFinanciereRepository situationFinanciereRepository) {
        this.situationFinanciereRepository = situationFinanciereRepository;
    }

    public static SituationFinanciere saveSituationFinanciere(SituationFinanciere situationFinanciere) {
        return situationFinanciereRepository.save(situationFinanciere);
    }

    public static SituationFinanciere updateSituationFinanciere(SituationFinanciere situationFinanciere) {
        return situationFinanciereRepository.save(situationFinanciere);
    }

    public static void deleteSituationFinanciereById(Long id) {
        situationFinanciereRepository.deleteById(id);
    }

    public static void deleteSituationFinanciere(SituationFinanciere situationFinanciere) {
        situationFinanciereRepository.delete(situationFinanciere);
    }

    public static SituationFinanciere getSituationFinanciereById(Long id) {
        return situationFinanciereRepository.findById(id).get();
    }

    public static Iterable<SituationFinanciere> getAllSituationFinancieres() {
        return situationFinanciereRepository.findAll();
    }


}
