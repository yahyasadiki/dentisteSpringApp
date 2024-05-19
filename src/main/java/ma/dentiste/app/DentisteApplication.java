package ma.dentiste.app;

import ma.dentiste.app.Respository.DentisteRepository;
import ma.dentiste.app.Respository.UtilisateurRepository;
import ma.dentiste.app.entites.Dentiste;
import ma.dentiste.app.entites.Personne;
import ma.dentiste.app.entites.Utilisateur;
import ma.dentiste.app.entites.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentisteApplication implements CommandLineRunner {

    @Autowired
    private DentisteRepository dentisteRepository;

    public static void main(String[] args) {
        SpringApplication.run(DentisteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    }
}

