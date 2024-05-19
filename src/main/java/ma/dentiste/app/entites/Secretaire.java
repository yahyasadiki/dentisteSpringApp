package ma.dentiste.app.entites;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.Assurance;
import ma.dentiste.app.entites.enums.StatusEmploye;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Secretaire extends Utilisateur{
    private Double salaireDeBase;
    private LocalDate dateRetourConge;
    private Assurance assurance;
    private Double prime;
    @Enumerated(EnumType.STRING)
    private StatusEmploye statusActuel;
}
