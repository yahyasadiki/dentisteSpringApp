package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Consultation;
import ma.dentiste.app.entites.DossierMedicale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByDossierMedicale(DossierMedicale dossierMedicale);
}

