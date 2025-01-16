package exp4;

import java.util.Random;

public class Cmmdc {
    public static void main(String[] args) {
        Random random = new Random();


        int numar1 = random.nextInt(30) + 1;
        int numar2 = random.nextInt(30) + 1;

        System.out.println("Numerele generate sunt: " + numar1 + " și " + numar2);

        int cmmdc = calculeazaCmmdc(numar1, numar2);

        // Afișarea rezultatului
        System.out.println("CMMDC-ul celor două numere este: " + cmmdc);
    }

    public static int calculeazaCmmdc(int a, int b) {
        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }
}


