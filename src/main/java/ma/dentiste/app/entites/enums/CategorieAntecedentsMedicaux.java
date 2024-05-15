package ma.dentiste.app.entites.enums;

public enum CategorieAntecedentsMedicaux {
    RisqueAssocie,
    MaladieChronique,
    ContreIndication,
    MaladieHereditaire,
    Allergie,
    Autre;

    private String description;

    private CategorieAntecedentsMedicaux(String description) {
    	this.description=description;
    }

    private CategorieAntecedentsMedicaux() {
    }

    public String getDescription() {
    	return description;
    }

    public void setDescription(String description) {
    	this.description=description;
    }
}
