package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.*;

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
