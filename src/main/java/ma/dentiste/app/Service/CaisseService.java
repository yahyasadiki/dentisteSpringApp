package ma.dentiste.app.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.dentiste.app.Respository.CaisseRepository;
import ma.dentiste.app.Service.FactureService;
import ma.dentiste.app.entites.Caisse;
import ma.dentiste.app.entites.Facture;

import java.time.LocalDate;
import java.util.List;
@Service
public class CaisseService {

    @Autowired
    private CaisseRepository caisseRepository;

    @Autowired
    private FactureService factureService;

    public Caisse createNewCaisse() {
        Caisse caisse = new Caisse();

        // Calculate the daily, monthly, and annual income
        List<Facture> allFactures = factureService.getAllFactures();

        double dailyIncome = 0.0;
        double monthlyIncome = 0.0;
        double annualIncome = 0.0;

        for (Facture facture : allFactures) {
            if (facture.getDateFacturation().isEqual(LocalDate.now())) {
                dailyIncome += facture.getMontantTotal();
            }
            if (facture.getDateFacturation().getMonth() == LocalDate.now().getMonth()) {
                monthlyIncome += facture.getMontantTotal();
            }
            if (facture.getDateFacturation().getYear() == LocalDate.now().getYear()) {
                annualIncome += facture.getMontantTotal();
            }
        }

        caisse.setRecetteDuJour(dailyIncome);
        caisse.setRecetteDuMois(monthlyIncome);
        caisse.setRecetteAnnuelle(annualIncome);

        return caisseRepository.save(caisse);
    }

    //getAllCaisses
    public List<Caisse> getAllCaisses() {
        return caisseRepository.findAll();
    }

}