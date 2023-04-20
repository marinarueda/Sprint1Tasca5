package exercici1;

import java.io.File;
import java.util.Arrays;

public class Programa1 {
    public static void main(String[] args) {

        if (args.length == 1) {
            File directori = new File(args[0]);

            if (directori.isDirectory()) {
                File[] elements = directori.listFiles();
                Arrays.sort(elements);

                for (File element : elements) {
                    if (element.isFile()) {
                        System.out.println(element.getName());
                    }
                }
            } else {
                System.out.println(args[0] + " no és un directori");
            }
        } else {
            System.out.println("Usage: java LlistarDirectori <ruta del directori>");
        }
    }
}


