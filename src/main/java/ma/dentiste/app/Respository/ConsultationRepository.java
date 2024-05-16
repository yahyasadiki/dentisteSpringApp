package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}

