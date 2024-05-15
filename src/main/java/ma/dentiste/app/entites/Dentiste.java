package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.Disponibilite;
import ma.dentiste.app.entites.enums.Specialite;
import ma.dentiste.app.entites.enums.StatusEmploye;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentiste extends Personne {

    @Column(nullable = false)
    private LocalDate DateRetourDeConge;

    @Column(nullable = false)
    private Double salaireDeBase;

    @Column(nullable = false)
    private Specialite specialite;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private Map<DayOfWeek, Disponibilite> disponibilite;

    @Enumerated(EnumType.STRING)
    private StatusEmploye statusEmploye;
}
