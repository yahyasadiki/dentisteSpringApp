package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Personne implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personne;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private String adresse;
    @Column(unique = true, length = 10)
    private String telephone;
    @Column(unique = true)
    private String email;
    @Column(unique = true, length = 8)
    private String cin;

}
