package exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Programa3 {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Se tiene que especificar la ruta como argumento");
            return;
        }

        String ruta = args[0];
        File directorio = new File(ruta);

        if (!directorio.isDirectory()) {
            System.out.println(ruta + " no es un directorio");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        FileWriter fw = new FileWriter("listar-arbol.txt");
        PrintWriter pw = new PrintWriter(fw);

        listarArbolRecursivo(directorio, pw, "", sdf);

        pw.close();
        fw.close();

        System.out.println("Se ha guardado el continudo en un directorio de fichero 'listar-arbol.txt'");
    }

    private static void listarArbolRecursivo(File directorio, PrintWriter pw, String prefix, SimpleDateFormat sdf) {
        File[] elements = directorio.listFiles();
        Arrays.sort(elements);

        for (int i = 0; i < elements.length; i++) {
            File element = elements[i];
            String fechaModificion = sdf.format(new Date(element.lastModified()));

            if (element.isFile()) {
                pw.println(prefix + "F " + element.getName() + " " + fechaModificion);
            } else {
                pw.println(prefix + "D " + element.getName() + " " + fechaModificion);
                listarArbolRecursivo(element, pw, prefix + "   ", sdf);
            }
        }
    }
}

