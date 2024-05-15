package ma.dentiste.app.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.CategorieActe;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Acte implements Serializable {

    @Id
    @GeneratedValue
    private Long idActe;
    @OneToMany(mappedBy = "acte", cascade = CascadeType.ALL)
    private List<InterventionMedicale> interventionsMedicales;
    private Double prixDeBase;
    private CategorieActe categorieActe;
    private String libelle;
}