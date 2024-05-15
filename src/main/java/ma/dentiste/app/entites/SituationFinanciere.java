package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SituationFinanciere implements Serializable {
    @Id
    @GeneratedValue
    private Long idSituationFinanciere;
    @OneToOne
    private DossierMedicale dossierMedicale;
    private LocalDate dateCreation;
    private Double montantGlobalRestant;
    private Double montantGlobalPaye;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Facture> factures;
}
