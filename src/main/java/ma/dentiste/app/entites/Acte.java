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
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActe;

    @OneToMany(mappedBy = "acte", cascade = CascadeType.ALL)
    private List<InterventionMedicale> interventionsMedicales;

    private Double prixDeBase;

    @Enumerated(EnumType.STRING)
    private CategorieActe categorieActe;

    private String libelle;
}
