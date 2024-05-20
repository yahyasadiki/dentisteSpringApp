package ma.dentiste.app;


import ma.dentiste.app.Respository.*;
import ma.dentiste.app.Service.ActeService;
import ma.dentiste.app.entites.*;
import ma.dentiste.app.entites.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.List;

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

