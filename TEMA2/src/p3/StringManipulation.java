package p3;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citirea șirului de caractere de la utilizator
        System.out.println("Introduceți șirul principal:");
        String textInitial = scanner.nextLine();

        // Crearea unui obiect StringBuilder pe baza textului introdus
        StringBuilder stringBuilder = new StringBuilder(textInitial);

        // Operația de inserare
        System.out.println("Introduceți șirul care va fi inserat:");
        String textDeInserat = scanner.nextLine();
        System.out.println("Introduceți poziția la care va fi inserat șirul:");
        int pozitieInserare = scanner.nextInt();
        scanner.nextLine(); // Consumă linia rămasă

        if (pozitieInserare >= 0 && pozitieInserare <= stringBuilder.length()) {
            stringBuilder.insert(pozitieInserare, textDeInserat);
            System.out.println("Șirul după inserare: " + stringBuilder.toString());
        } else {
            System.out.println("Poziția de inserare este invalidă!");
        }

        // Operația de ștergere
        System.out.println("Introduceți poziția de început pentru ștergere:");
        int pozitieStergere = scanner.nextInt();
        System.out.println("Introduceți numărul de caractere de șters:");
        int numarCaractere = scanner.nextInt();

        if (pozitieStergere >= 0 && pozitieStergere < stringBuilder.length() &&
                pozitieStergere + numarCaractere <= stringBuilder.length()) {
            stringBuilder.delete(pozitieStergere, pozitieStergere + numarCaractere);
            System.out.println("Șirul după ștergere: " + stringBuilder.toString());
        } else {
            System.out.println("Parametrii pentru ștergere sunt invalizi!");
        }
    }
}

