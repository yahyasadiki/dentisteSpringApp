package ma.dentiste.app;


import ma.dentiste.app.Respository.ActeRepository;
import ma.dentiste.app.Respository.AntecedentMedicaleRepository;
import ma.dentiste.app.Respository.DentisteRepository;
import ma.dentiste.app.Respository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentisteApplication implements CommandLineRunner {

    @Autowired
    private DentisteRepository dentisteRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AntecedentMedicaleRepository antecedentMedicaleRepository;
    @Autowired
    private ActeRepository acteRepository;

    public static void main(String[] args) {
        SpringApplication.run(DentisteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}

