package firma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final List<Echipament> echipamente = new ArrayList<>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        citireFisier("C:\\Users\\Biu\\IdeaProjects\\laborator4\\src\\firma\\echipamente.txt");
        afisareMeniu();
    }

    private static void citireFisier(String numeFisier) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] date = linie.split(";");
                String denumire = date[0];
                int nrInv = Integer.parseInt(date[1]);
                double pret = Double.parseDouble(date[2]);
                char zonaMag = date[3].charAt(0);
                StareEchipament stare = StareEchipament.valueOf(date[4].toUpperCase());
                String tip = date[5].toLowerCase();

                switch (tip) {
                    case "imprimanta":
                        int ppm = Integer.parseInt(date[6]);
                        String rezolutie = date[7];
                        int paginiCartus = Integer.parseInt(date[8]);
                        ModScriere modScriere = ModScriere.valueOf(date[9].toUpperCase());
                        echipamente.add(new Imprimanta(denumire, nrInv, pret, zonaMag, stare, ppm, rezolutie, paginiCartus, modScriere));
                        break;
                    case "copiator":
                        int paginiToner = Integer.parseInt(date[6]);
                        FormatCopiere formatCopiere = FormatCopiere.valueOf(date[7].toUpperCase());
                        echipamente.add(new Copiator(denumire, nrInv, pret, zonaMag, stare, paginiToner, formatCopiere));
                        break;
                    case "sistem de calcul":
                        String tipMonitor = date[6];
                        double vitezaProcesor = Double.parseDouble(date[7]);
                        int capacitateHDD = Integer.parseInt(date[8]);
                        SistemOperare sistemOperare = SistemOperare.valueOf(date[9].toUpperCase());
                        echipamente.add(new SistemCalcul(denumire, nrInv, pret, zonaMag, stare, tipMonitor, vitezaProcesor, capacitateHDD, sistemOperare));
                        break;
                }
            }
        }
    }

    private static void afisareMeniu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișarea tuturor echipamentelor");
            System.out.println("2. Afișarea imprimantelor");
            System.out.println("3. Afișarea copiatoarelor");
            System.out.println("4. Afișarea sistemelor de calcul");
            System.out.println("5. Modificarea stării unui echipament");
            System.out.println("6. Setarea modului de scriere pentru o imprimantă");
            System.out.println("7. Setarea formatului de copiere pentru un copiator");
            System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("9. Afișarea echipamentelor vândute");
            System.out.println("10. Ieșire");
            System.out.print("Alegeți o opțiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1 -> echipamente.forEach(System.out::println);
                case 2 -> echipamente.stream().filter(e -> e instanceof Imprimanta).forEach(System.out::println);
                case 3 -> echipamente.stream().filter(e -> e instanceof Copiator).forEach(System.out::println);
                case 4 -> echipamente.stream().filter(e -> e instanceof SistemCalcul).forEach(System.out::println);
                case 5 -> modificareStare(scanner);
                case 6 -> setareModScriere(scanner);
                case 7 -> setareFormatCopiere(scanner);
                case 8 -> instalareSistemOperare(scanner);
                case 9 -> echipamente.stream().filter(e -> e.stare == StareEchipament.VANDUT).forEach(System.out::println);
                case 10 -> {
                    System.out.println("Ieșire din program.");
                    return;
                }
                default -> System.out.println("Opțiune invalidă!");
            }
        }
    }

    private static void modificareStare(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduceți noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
        StareEchipament stare = StareEchipament.valueOf(scanner.nextLine().toUpperCase());
        echipamente.stream().filter(e -> e.nrInv == nrInv).findFirst().ifPresent(e -> e.setStare(stare));
    }

    private static void setareModScriere(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar al imprimantei: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduceți modul de scriere (COLOR, ALB_NEGRU): ");
        ModScriere modScriere = ModScriere.valueOf(scanner.nextLine().toUpperCase());
        echipamente.stream().filter(e -> e.nrInv == nrInv && e instanceof Imprimanta).map(e -> (Imprimanta) e).findFirst().ifPresent(i -> i.setModScriere(modScriere));
    }

    private static void setareFormatCopiere(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar al copiatorului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduceți formatul de copiere (A3, A4): ");
        FormatCopiere formatCopiere = FormatCopiere.valueOf(scanner.nextLine().toUpperCase());
        echipamente.stream().filter(e -> e.nrInv == nrInv && e instanceof Copiator).map(e -> (Copiator) e).findFirst().ifPresent(c -> c.setFormatCopiere(formatCopiere));
    }

    private static void instalareSistemOperare(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar al sistemului de calcul: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduceți sistemul de operare (WINDOWS, LINUX): ");
        SistemOperare sistemOperare = SistemOperare.valueOf(scanner.nextLine().toUpperCase());
        echipamente.stream().filter(e -> e.nrInv == nrInv && e instanceof SistemCalcul).map(e -> (SistemCalcul) e).findFirst().ifPresent(s -> s.setSistemOperare(sistemOperare));
    }
}


