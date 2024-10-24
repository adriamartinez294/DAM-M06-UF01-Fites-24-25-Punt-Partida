package cat.iesesteveterradas.fites;

import cat.iesesteveterradas.fites.objectes.*;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa codi que compleixi el següent:
 * 
 * - Llegeix el fitxer binari 'Exercici2.dat' situat al directori de treball especificat.
 * - Llegeix els blocs de dades que contenen informació sobre cada persona (nom, cognom, any de naixement).
 * - Crea objectes de tipus 'Exercici2Persona' per a cada conjunt de dades llegit.
 * - Retorna una llista d'objectes 'Exercici2Persona' amb les dades llegides.
 * - La impressió de les dades es fa en un mètode separat que recorre la llista i mostra la informació de cada persona.
 * - Ha de poder gestionar qualsevol quantitat de persones dins del fitxer, sense suposar una mida fixa.
 * - Gestió d'errors: si hi ha algun problema en llegir el fitxer (ex. fitxer no trobat), ha de mostrar l'excepció a la consola.
 */
public class Exercici2Llegeix {
    private String filePath;

    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/exercici2/";
        String filePath = basePath + "Exercici2.dat";

        Exercici2Llegeix exercici = new Exercici2Llegeix();
        exercici.configurarRutaFitxerEntrada(filePath);
        exercici.executa();
    }

    public void executa() {
        List<Exercici2Persona> persones = llegeixFitxer(filePath);
        imprimeixPersones(persones);
    }

    // Mètode que llegeix el fitxer i retorna una llista de persones
    public List<Exercici2Persona> llegeixFitxer(String filePath) {
        // *************** CODI EXERCICI FITA **********************/
        List<Exercici2Persona> llistaPersones = new ArrayList<Exercici2Persona>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                String nom = dis.readUTF();
                String cognom = dis.readUTF();
                int any = dis.readInt();
                Exercici2Persona persona = new Exercici2Persona(nom, cognom, any);
                llistaPersones.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return llistaPersones; // A substituir 
    }

    // Mètode que imprimeix les dades de la llista de persones
    public void imprimeixPersones(List<Exercici2Persona> persones) {
        // *************** CODI EXERCICI FITA **********************/
        for (Exercici2Persona persona : persones) {
            System.out.println(persona);
        }
    }

    /****************************************************************************/
    /*                          NO CAL MODIFICAR                                */
    /****************************************************************************/       
    // Setter per definir el path
    public void configurarRutaFitxerEntrada(String filePath) {
        this.filePath = filePath;
    }

    // Getter per obtenir el path
    public String obtenirRutaFitxerEntrada() {
        return this.filePath;
    }
}
