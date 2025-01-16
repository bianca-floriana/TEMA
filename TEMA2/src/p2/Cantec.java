package p2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cantec {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Biu\\Downloads\\TEMA2\\src\\p2\\cantec_in.txt";
        String outputFile = "C:\\Users\\Biu\\Downloads\\TEMA2\\src\\p2\\cantec_out.txt";

        try {
            List<Vers> versuri = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Biu\\Downloads\\TEMA2\\src\\p2\\cantec_in.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                versuri.add(new Vers(line.trim()));
            }
            br.close();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceți gruparea de litere pentru marcarea cu steluță (*):");
            String grupare = scanner.nextLine().trim();


            PrintWriter pw = new PrintWriter("C:\\Users\\Biu\\Downloads\\TEMA2\\src\\p2\\cantec_out.txt");
            Random random = new Random();

            for (Vers vers : versuri) {
                StringBuilder rezultat = new StringBuilder();


                String textVers = vers.getVers();
                if (random.nextDouble() < 0.1) {
                    textVers = vers.getVersCuMajuscule();
                }
                rezultat.append(textVers);


                rezultat.append(" [Cuvinte: ").append(vers.getNrCuvinte()).append(", Vocale: ").append(vers.getNrVocale()).append("]");


                if (vers.seTerminaCu(grupare)) {
                    rezultat.append(" *");
                }


                pw.println(rezultat.toString());
            }

            pw.close();
            System.out.println("Fișierul " + outputFile + " a fost generat cu succes!");

        } catch (IOException e) {
            System.err.println("Eroare la procesarea fișierelor: " + e.getMessage());
        }
    }
}
