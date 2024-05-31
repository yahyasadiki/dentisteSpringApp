package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InterventionMedicale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInterventionMedicale;
    private String noteMedecin;
    private Long dent;
    private double prixPatient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idConsultation")
    private Consultation consultation;

    @ManyToOne
    @JoinColumn(name = "idActe")
    private Acte acte;
}