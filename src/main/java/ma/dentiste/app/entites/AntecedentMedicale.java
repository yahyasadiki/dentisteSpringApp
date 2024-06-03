package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.CategorieAntecedentsMedicaux;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AntecedentMedicale implements Serializable {
    @Id
    @GeneratedValue
    private Long idAntecedent;
    private String libelle;
    @ManyToMany
    private List<Patient> patientAvectAntecedent;
    @Enumerated(EnumType.STRING)
    private CategorieAntecedentsMedicaux categorieAntecedentsMedicaux;
}
