package cat.iesesteveterradas.fites.objectes;

import java.io.Serializable;
import java.util.Objects;

/**
 * Estem parlant de serialitzar objectes.
 * Cal que s'asseguris que aquesta classe implementa
 * el necessari.
 */

public class Exercici3nau implements Serializable {
    private static final long serialVersionUID = 1L;

    String nom;
    String pais;
    int any;

    public Exercici3nau (String nom, String pais, int any) {
        this.nom = nom;
        this.pais = pais;
        this.any = any;
    }

    @Override
    public String toString () {
        return this.nom + ", " + this.pais + " " + this.any;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercici3nau)) return false;
        Exercici3nau that = (Exercici3nau) o;
        return any == that.any &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, pais, any);
    }
}