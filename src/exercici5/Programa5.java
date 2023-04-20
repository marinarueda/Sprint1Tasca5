package exercici5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Programa5 {

    public static void main(String[] args) throws Exception {
        Serializacion obj = new Serializacion(42, "Hello, World!");

        FileOutputStream fos = new FileOutputStream("object.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(obj);

        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("object.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Serializacion obj1 = (Serializacion) ois.readObject();

        ois.close();
        fis.close();

        System.out.println(obj1.valor);
        System.out.println(obj1.mensaje);
    }
}