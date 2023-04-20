package exercici4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Programa4 {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Se tiene que especificar el nombre del archivo como argumento");
            return;
        }

        String nombreArchivo = args[0];
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

        br.close();
    }
}
