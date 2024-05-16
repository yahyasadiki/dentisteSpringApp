package ma.dentiste.app;

import ma.dentiste.app.Respository.UtilisateurRepository;
import ma.dentiste.app.entites.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentisteApplication implements CommandLineRunner {
    @Autowired
    UtilisateurRepository daoUtilisateur;
    public static void main(String[] args) {
        SpringApplication.run(DentisteApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Utilisateur utilisateur = new Utilisateur(1L,"admin", "2002", null);
        daoUtilisateur.save(utilisateur);
    }
}
