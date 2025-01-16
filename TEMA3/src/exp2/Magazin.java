package exp2;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Magazin {
    private static List<Produs> produse = new ArrayList<>();

    public static void main(String[] args) {
        try {
            citireProduseDinFisier("C:\\Users\\Biu\\Downloads\\laborator3\\src\\exp2\\produse.csv");
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișare produse");
            System.out.println("2. Afișare produse expirate");
            System.out.println("3. Vânzare produs");
            System.out.println("4. Afișare produse cu prețul minim");
            System.out.println("5. Salvare produse cu cantitate mică");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline-ul

            switch (optiune) {
                case 1:
                    afisareProduse();
                    break;
                case 2:
                    afisareProduseExpirate();
                    break;
                case 3:
                    vanzareProdus(scanner);
                    break;
                case 4:
                    afisareProdusePretMinim();
                    break;
                case 5:
                    salvareProduseCantitateMica(scanner);
                    break;
                case 0:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        } while (optiune != 0);
    }


    public static void citireProduseDinFisier(String numeFisier) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split(",");
                String denumire = valori[0].trim();
                double pret = Double.parseDouble(valori[1].trim());
                int cantitate = Integer.parseInt(valori[2].trim());
                LocalDate dataExpirarii = LocalDate.parse(valori[3].trim());
                produse.add(new Produs(denumire, pret, cantitate, dataExpirarii));
            }
        }
    }


    public static void afisareProduse() {
        if (produse.isEmpty()) {
            System.out.println("Nu există produse în magazin.");
        } else {
            produse.forEach(System.out::println);
        }
    }


    public static void afisareProduseExpirate() {
        LocalDate azi = LocalDate.now();
        List<Produs> produseExpirate = produse.stream()
                .filter(p -> p.getDataExpirarii().isBefore(azi))
                .collect(Collectors.toList());

        if (produseExpirate.isEmpty()) {
            System.out.println("Nu există produse expirate.");
        } else {
            produseExpirate.forEach(System.out::println);
        }
    }


    public static void vanzareProdus(Scanner scanner) {
        System.out.print("Introduceți denumirea produsului: ");
        String denumire = scanner.nextLine();
        System.out.print("Introduceți cantitatea dorită: ");
        int cantitate = scanner.nextInt();

        Produs produs = produse.stream()
                .filter(p -> p.getDenumire().equalsIgnoreCase(denumire))
                .findFirst()
                .orElse(null);

        if (produs == null) {
            System.out.println("Produsul nu există.");
        } else if (produs.getCantitate() < cantitate) {
            System.out.println("Cantitate insuficientă pe stoc.");
        } else {
            produs.setCantitate(produs.getCantitate() - cantitate);
            Produs.incasari += cantitate * produs.getPret();
            System.out.println("Produs vândut cu succes.");

            if (produs.getCantitate() == 0) {
                produse.remove(produs);
                System.out.println("Produsul a fost eliminat din stoc.");
            }
        }
    }


    public static void afisareProdusePretMinim() {
        OptionalDouble pretMinim = produse.stream()
                .mapToDouble(Produs::getPret)
                .min();

        if (pretMinim.isPresent()) {
            double minim = pretMinim.getAsDouble();
            produse.stream()
                    .filter(p -> p.getPret() == minim)
                    .forEach(System.out::println);
        } else {
            System.out.println("Nu există produse în magazin.");
        }
    }


    public static void salvareProduseCantitateMica(Scanner scanner) {
        System.out.print("Introduceți cantitatea maximă: ");
        int cantitateMaxima = scanner.nextInt();

        List<Produs> produseCantitateMica = produse.stream()
                .filter(p -> p.getCantitate() < cantitateMaxima)
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Biu\\Downloads\\TEMA3\\src\\exp2\\produse_mici.csv"))) {
            for (Produs produs : produseCantitateMica) {
                writer.write(produs.toString());
                writer.newLine();
            }
            System.out.println("Produsele au fost salvate în fișierul produse_mici.csv.");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }
}
