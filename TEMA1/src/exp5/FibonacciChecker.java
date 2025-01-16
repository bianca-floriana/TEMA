package exp5;

import java.util.Random;

public class FibonacciChecker {
    public static void main(String[] args) {
        Random random = new Random();

        int numar = random.nextInt(21); // [0, 20]
        System.out.println("Numărul generat este: " + numar);

        if (esteFibonacci(numar)) {
            System.out.println("Numărul " + numar + " aparține șirului lui Fibonacci.");
        } else {
            System.out.println("Numărul " + numar + " nu aparține șirului lui Fibonacci.");
        }
    }

    public static boolean esteFibonacci(int numar) {
        if (numar < 0) return false;

        // Verificăm dacă 5 * numar^2 + 4 sau 5 * numar^2 - 4 este un pătrat perfect
        int test1 = 5 * numar * numar + 4;
        int test2 = 5 * numar * numar - 4;

        return estePatratPerfect(test1) || estePatratPerfect(test2);
    }

    public static boolean estePatratPerfect(int numar) {
        int radacina = (int) Math.sqrt(numar);
        return radacina * radacina == numar;
    }
}

