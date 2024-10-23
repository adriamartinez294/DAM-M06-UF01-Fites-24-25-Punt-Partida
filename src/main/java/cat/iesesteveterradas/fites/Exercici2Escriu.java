package cat.iesesteveterradas.fites;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* NO CAL FER RES EN AQUEST FITXER */
public class Exercici2Escriu {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/exercici2/";
        String filePath = basePath + "Exercici2.dat";

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("Billie");
            dos.writeUTF("Eilish");
            dos.writeInt(2001);

            dos.writeUTF("Bruno");
            dos.writeUTF("Mars");
            dos.writeInt(1985);

            dos.writeUTF("Ariana");
            dos.writeUTF("Grande");
            dos.writeInt(1993);

            dos.writeUTF("Abel");
            dos.writeUTF("Tesfaye");
            dos.writeInt(1990);

            dos.flush();
            dos.close();
            fos.close();

            System.out.println("Llest");

        } catch (IOException e) { e.printStackTrace(); }
    }
}
