package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.dentiste.app.entites.enums.TypePaiment;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private Double montantRestant;

    @ManyToOne
    private SituationFinanciere situationFinanciere;

    private Double montantPaye;
    private LocalDate dateFacturation;
    private Double montantTotal;

    @ManyToOne
    private Consultation consultation;

    @Enumerated(EnumType.STRING)
    private TypePaiment typePaiment;
}
