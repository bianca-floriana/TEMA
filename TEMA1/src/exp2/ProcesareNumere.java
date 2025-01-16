package exp2;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcesareNumere {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Biu\\Downloads\\TEMA1\\src\\exp2\\in.txt";
        String outputFile = "C:\\Users\\Biu\\Downloads\\TEMA1\\src\\exp2\\out.txt";


        List<Integer> numere = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String linie;
            while ((linie = reader.readLine()) != null) {
                numere.add(Integer.parseInt(linie.trim()));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Eroare la citirea fișierului. Verificați formatul și existența acestuia.");
            return;
        }


        int suma = 0;
        int minim = Integer.MAX_VALUE;
        int maxim = Integer.MIN_VALUE;
        for (int numar : numere) {
            suma += numar;
            if (numar < minim) minim = numar;
            if (numar > maxim) maxim = numar;
        }
        double media = (double) suma / numere.size();


        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Valoarea minimă: " + minim);
        System.out.println("Valoarea maximă: " + maxim);


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write("Suma: " + suma + "\n");
            writer.write("Media: " + media + "\n");
            writer.write("Valoarea minimă: " + minim + "\n");
            writer.write("Valoarea maximă: " + maxim + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Eroare la scrierea fișierului.");
        }
    }
}

