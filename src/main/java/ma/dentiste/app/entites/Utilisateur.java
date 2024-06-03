package ma.dentiste.app.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur extends Personne {
    private String nomUtilisateur;
    private String motDePasse;
    @Enumerated(EnumType.STRING)
    private Role roles;
}

