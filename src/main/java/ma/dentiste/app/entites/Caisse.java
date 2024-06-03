package ma.dentiste.app.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Caisse implements Serializable {
    @Id
    @GeneratedValue
    private Long idCaisse;
    private Double recetteDuJour;
    private Double recetteDuMois;
    private Double recetteAnnuelle;
    @OneToMany
    private List<SituationFinanciere> situationFinancieres;
}
