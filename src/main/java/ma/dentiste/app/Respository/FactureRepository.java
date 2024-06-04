package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Consultation;
import ma.dentiste.app.entites.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    Collection<? extends Facture> findByConsultation(Consultation consultation);
}
