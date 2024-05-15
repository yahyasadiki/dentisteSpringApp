package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.StatusPaiment;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DossierMedicale implements Serializable {
    @Id
    @GeneratedValue
    private Long numeroDossier;
    private LocalDate dateCreation;
    @OneToOne
    private Patient patient;
    @OneToOne
    private SituationFinanciere situationFinanciere;
    @ManyToOne
    private Dentiste dentiste;
    @Enumerated(EnumType.STRING)
    private StatusPaiment statusPaiment;
}
