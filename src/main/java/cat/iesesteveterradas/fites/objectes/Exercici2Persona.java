package cat.iesesteveterradas.fites.objectes;

public class Exercici2Persona {
    private String nom;
    private String cognom;
    private int any;

    public Exercici2Persona(String nom, String cognom, int any) {
        this.nom = nom;
        this.cognom = cognom;
        this.any = any;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public int getAnyNaixement() {
        return any;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setAnyNaixement(int any) {
        this.any = any;
    }

    @Override
    public String toString() {
        return this.nom + " " + this.cognom + ", " + this.any;
    }
}
