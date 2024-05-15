package ma.dentiste.app.entites.enums;

public enum StatusPaiment {
    EN_ATTENTE, PAYE, NON_PAYE;

    private String description;

    private StatusPaiment() {
    }

    private StatusPaiment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
