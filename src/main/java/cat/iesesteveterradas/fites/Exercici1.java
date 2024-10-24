package cat.iesesteveterradas.fites;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Implementa codi que compleixi el següent:
 * 
 * - Llegeix un fitxer de text d'entrada amb codificació UTF-8.
 * - Inverteix el text de cada línia utilitzant el mètode 'giraText'.
 * - Escriu les línies invertides en un fitxer de sortida amb codificació UTF-8.
 * - El fitxer de sortida es crea o sobrescriu si ja existeix.
 * - Si hi ha un error en llegir o escriure els fitxers, l'excepció es mostra a la consola.
 */
public class Exercici1 {

    private String filePathIn;
    private String filePathOut;


    public static void main(String args[]) {
        Exercici1 exercici = new Exercici1();
        // Configurar els fitxers d'entrada i sortida
        exercici.configuraRutaFitxerEntrada(System.getProperty("user.dir") + "/data/exercici1/Exercici1Entrada.txt");
        exercici.configuraRutaFitxerSortida(System.getProperty("user.dir") + "/data/exercici1/Exercici1Solucio.txt");
        // Executar la lògica principal
        exercici.executa();
    }    

    // Processa el fitxer d'entrada i genera el fitxer de sortida.
    public void executa() {
        // *************** CODI EXERCICI FITA **********************/
        File fitxerSortida = new File(filePathOut);
        

        try {
            fitxerSortida.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<String> linies = Files.readAllLines(Paths.get(filePathIn));
            for (String linea : linies) {
                String lineaGirada = giraText(linea);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathOut, StandardCharsets.UTF_8, true))) {
                    writer.write(lineaGirada);
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("Error en escriure l'arxiu: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura del fitxer: " + filePathIn);
            e.printStackTrace();
        }
    }

    // Mètode per invertir el text d'una línia
    public static String giraText(String text) {
        // *************** CODI EXERCICI FITA **********************/
        String textGirat = "";

        for (int i = text.length() - 1; i >= 0; i--) {

			textGirat = textGirat + text.charAt(i);
		}
		return textGirat; // A substituir 
    }

    /****************************************************************************/
    /*                          NO CAL MODIFICAR                                */
    /****************************************************************************/
    // Mètode per configurar el fitxer d'entrada
    public void configuraRutaFitxerEntrada(String filePathIn) {
        this.filePathIn = filePathIn;
    }

    // Mètode per configurar el fitxer de sortida
    public void configuraRutaFitxerSortida(String filePathOut) {
        this.filePathOut = filePathOut;
    }
}
