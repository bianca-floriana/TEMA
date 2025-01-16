package p4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citim numărul de persoane
        System.out.println("Introduceți numărul de persoane:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumăm linia rămasă

        // Creăm un vector pentru a stoca obiectele de tip Persoana
        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceți numele persoanei " + (i + 1) + ":");
            String nume = scanner.nextLine();

            String cnp;
            while (true) {
                System.out.println("Introduceți CNP-ul persoanei " + (i + 1) + ":");
                cnp = scanner.nextLine();

                if (esteCnpValid(cnp)) {
                    break; // Ieșim din buclă dacă CNP-ul este valid
                } else {
                    System.out.println("CNP invalid! Vă rugăm să reintroduceți.");
                }
            }

            // Adăugăm persoana în vector
            persoane[i] = new Persoana(nume, cnp);
        }

        // Afișăm informațiile despre fiecare persoană
        System.out.println("\nInformații persoane:");
        for (Persoana persoana : persoane) {
            System.out.println(persoana.getNume() + ", " + persoana.getCnp() + ", " + persoana.getVarsta() + " ani");
        }
    }

    // Metodă pentru validarea unui CNP
    private static boolean esteCnpValid(String cnp) {
        if (cnp.length() != 13 || !cnp.matches("\\d+")) {
            return false;
        }

        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }

        // Calculăm cifra de control
        int[] constante = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;

        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * constante[i];
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) {
            cifraControl = 1;
        }

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }
}
