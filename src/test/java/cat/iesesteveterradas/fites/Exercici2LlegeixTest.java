package cat.iesesteveterradas.fites;

import cat.iesesteveterradas.fites.objectes.Exercici2Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Exercici2LlegeixTest {

    private Exercici2Llegeix exercici;
    private File fileEntrada;

    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() {
        exercici = new Exercici2Llegeix();
        // Crear fitxer d'entrada al directori temporal
        fileEntrada = new File(tempDir.toFile(), "Exercici2Test.dat");
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileEntrada))) {
            // Escriu noves persones al fitxer d'entrada
            dos.writeUTF("Taylor");
            dos.writeUTF("Swift");
            dos.writeInt(1989);

            dos.writeUTF("Ed");
            dos.writeUTF("Sheeran");
            dos.writeInt(1991);

            dos.writeUTF("Adele");
            dos.writeUTF("Adkins");
            dos.writeInt(1988);

            dos.writeUTF("Shawn");
            dos.writeUTF("Mendes");
            dos.writeInt(1998);
        } catch (IOException e) {
            e.printStackTrace();
            fail("No s'ha pogut configurar el fitxer d'entrada per al test.");
        }
    }

    @Test
    public void testLlegeixFitxer() {
        // Crida al mètode llegeixFitxer i obté la llista de persones
        List<Exercici2Persona> persones = exercici.llegeixFitxer(fileEntrada.getAbsolutePath());

        // Comprova que la llista no és buida i que té la mida correcta
        assertNotNull(persones, "La llista de persones no hauria de ser nul·la.");
        assertEquals(4, persones.size(), "La llista de persones hauria de tenir 4 elements.");

        // Comprova que cada persona té les dades correctes
        assertEquals("Taylor", persones.get(0).getNom());
        assertEquals("Swift", persones.get(0).getCognom());
        assertEquals(1989, persones.get(0).getAnyNaixement());

        assertEquals("Ed", persones.get(1).getNom());
        assertEquals("Sheeran", persones.get(1).getCognom());
        assertEquals(1991, persones.get(1).getAnyNaixement());

        assertEquals("Adele", persones.get(2).getNom());
        assertEquals("Adkins", persones.get(2).getCognom());
        assertEquals(1988, persones.get(2).getAnyNaixement());

        assertEquals("Shawn", persones.get(3).getNom());
        assertEquals("Mendes", persones.get(3).getCognom());
        assertEquals(1998, persones.get(3).getAnyNaixement());
    }

    @Test
    public void testImprimeixPersones() {
        // Crea una llista simulada de persones amb dades diferents
        List<Exercici2Persona> persones = new ArrayList<>();
        persones.add(new Exercici2Persona("Taylor", "Swift", 1989));
        persones.add(new Exercici2Persona("Ed", "Sheeran", 1991));
        persones.add(new Exercici2Persona("Adele", "Adkins", 1988));
        persones.add(new Exercici2Persona("Shawn", "Mendes", 1998));

        // Captura la sortida per consola
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        // Executa el mètode imprimeixPersones
        exercici.imprimeixPersones(persones);

        // Comprova que la sortida és correcta
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "Taylor Swift, 1989" + lineSeparator +
                                "Ed Sheeran, 1991" + lineSeparator +
                                "Adele Adkins, 1988" + lineSeparator +
                                "Shawn Mendes, 1998" + lineSeparator;

        assertEquals(expectedOutput, outputStream.toString(), "La sortida per pantalla no coincideix amb l'esperada.");
    }
}
