package p1;

import java.io.*;
import java.util.*;

public class Judete {

    public static void main(String[] args) {
        String fileName = "judete_in.txt";

        try {
            List<String> judeteList = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Biu\\Downloads\\TEMA2\\src\\p1\\judete_in.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                judeteList.add(line.trim());
            }
            br.close();

            String[] judeteArray = judeteList.toArray(new String[0]);

            Arrays.sort(judeteArray);

            System.out.println("Județele ordonate:");
            for (String judet : judeteArray) {
                System.out.println(judet);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIntroduceți numele județului pentru căutare:");
            String judetCautat = scanner.nextLine().trim();

            int index = Arrays.binarySearch(judeteArray, judetCautat);

            if (index >= 0) {
                System.out.println("Județul " + judetCautat + " se află pe poziția " + index + " în vectorul ordonat.");
            } else {
                System.out.println("Județul " + judetCautat + " nu a fost găsit în listă.");
            }

        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
        }
    }
}

