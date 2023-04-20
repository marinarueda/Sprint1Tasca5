package exercici2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Programa2 {

    public static void main(String[] args) {
        if (args.length == 1) {
            File directorio = new File(args[0]);

            if (directorio.isDirectory()) {
                listarArbol(directorio, "");
            } else {
                    System.out.println(args[0] + " no es un directorio");
            }
        } else {
            System.out.println("Usage: java listarArbol <ruta del directorio>");
        }
    }

        public static void listarArbol(File directorio, String prefix) {
            File[] elements = directorio.listFiles();
            Arrays.sort(elements);

            for (File element : elements) {
                String nom = element.getName();
                Date dataModificacio = new Date(element.lastModified());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                if (element.isDirectory()) {
                    System.out.println(prefix + "D " + nom + " (modificat " + sdf.format(dataModificacio) + ")");
                    listarArbol(element, prefix + "    ");
                } else {
                    System.out.println(prefix + "F " + nom + " (modificat " + sdf.format(dataModificacio) + ")");
                }
            }
    }
}


