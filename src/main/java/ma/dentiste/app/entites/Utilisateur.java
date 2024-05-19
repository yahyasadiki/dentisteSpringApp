package ma.dentiste.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentiste.app.entites.enums.Role;

import java.io.Serializable;
import java.util.ArrayList;

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

