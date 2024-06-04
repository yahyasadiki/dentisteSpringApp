package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.TypeConsultation;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;
    private LocalDate dateConsultation;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    private List<InterventionMedicale> interventionsMedicales;

    @ManyToOne
    private DossierMedicale dossierMedicale;

    @Enumerated(EnumType.STRING)
    private TypeConsultation typeConsultation;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    private List<Facture> factures;
}

