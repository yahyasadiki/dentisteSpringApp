package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.GroupeSanguin;
import ma.dentiste.app.entites.enums.Mutuelle;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends Personne {
    private LocalDate dateNaissance;
    @Enumerated(EnumType.STRING)
    private Mutuelle mutuelle;
    @Enumerated(EnumType.STRING)
    private GroupeSanguin groupeSanguin;
    @ManyToMany
    private List<AntecedentMedicale> antecedentMedicales;
    @OneToOne
    private DossierMedicale dossierMedicale;
    private String profession;
}
