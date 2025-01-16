import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        Set<InstrumentMuzical> instrumente = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());

        boolean running = true;
        while (running) {
            System.out.println("\nMeniu Interactiv:");
            System.out.println("1. Adauga instrumente in colectie");
            System.out.println("2. Salveaza colectia in fisier");
            System.out.println("3. Incarca colectia din fisier");
            System.out.println("4. Afiseaza implementarea Set");
            System.out.println("5. Verifica duplicatele");
            System.out.println("6. Sterge instrumente cu pret mai mare de 3000 RON");
            System.out.println("7. Afiseaza datele chitarilor");
            System.out.println("8. Afiseaza datele tobelor");
            System.out.println("9. Afiseaza chitara cu cele mai multe corzi");
            System.out.println("10. Afiseaza tobele acustice ordonate dupa numarul de tobe");
            System.out.println("0. Iesire");
            System.out.print("Alege o optiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    instrumente.add(new Chitara("Gibson", 2500, Chitara.TipChitara.ELECTRICA, 6));
                    instrumente.add(new Chitara("Yamaha", 1500, Chitara.TipChitara.ACUSTICA, 12));
                    instrumente.add(new Chitara("Fender", 3000, Chitara.TipChitara.CLASICA, 6));
                    instrumente.add(new SetTobe("Roland", 4000, SetTobe.TipTobe.ELECTRONICE, 5, 2));
                    instrumente.add(new SetTobe("Pearl", 3500, SetTobe.TipTobe.ACUSTICE, 7, 3));
                    instrumente.add(new SetTobe("Tama", 2800, SetTobe.TipTobe.ACUSTICE, 6, 2));
                    System.out.println("Instrumentele au fost adaugate in colectie.");
                    break;
                case 2:
                    try {
                        mapper.writeValue(new File("C:\\Users\\Biu\\IdeaProjects\\labor7\\src\\main\\java\\instrumente.json"), instrumente);
                        System.out.println("Colectia a fost salvata in fisierul instrumente.json.");
                    } catch (IOException e) {
                        System.err.println("Eroare la salvarea colectiei: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        instrumente = mapper.readValue(new File("C:\\Users\\Biu\\IdeaProjects\\labor7\\src\\main\\java\\instrumente.json"), mapper.getTypeFactory().constructCollectionType(Set.class, InstrumentMuzical.class));
                        System.out.println("Colectia a fost incarcata din fisier.");
                    } catch (IOException e) {
                        System.err.println("Eroare la incarcarea colectiei: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Implementarea utilizata pentru Set: " + instrumente.getClass().getName());
                    break;
                case 5:
                    InstrumentMuzical duplicate = new Chitara("Fender", 3000, Chitara.TipChitara.CLASICA, 6);
                    if (!instrumente.add(duplicate)) {
                        System.out.println("Set-ul nu permite duplicate.");
                    } else {
                        System.out.println("Duplicatele sunt permise, dar acum au fost blocate.");
                    }
                    break;
                case 6:
                    instrumente.removeIf(instr -> instr.getPret() > 3000);
                    System.out.println("Instrumentele cu pret mai mare de 3000 RON au fost sterse.");
                    break;
                case 7:
                    instrumente.stream()
                            .filter(instr -> instr instanceof Chitara)
                            .forEach(System.out::println);
                    break;
                case 8:
                    instrumente.stream()
                            .filter(instr -> instr.getClass() == SetTobe.class)
                            .forEach(System.out::println);
                    break;
                case 9:
                    instrumente.stream()
                            .filter(instr -> instr instanceof Chitara)
                            .map(instr -> (Chitara) instr)
                            .max(Comparator.comparingInt(Chitara::getNrCorzi))
                            .ifPresentOrElse(System.out::println, () -> System.out.println("Nu exista chitari in colectie."));
                    break;
                case 10:
                    instrumente.stream()
                            .filter(instr -> instr instanceof SetTobe && ((SetTobe) instr).getTipTobe() == SetTobe.TipTobe.ACUSTICE)
                            .sorted(Comparator.comparingInt(instr -> ((SetTobe) instr).getNrTobe()))
                            .forEach(System.out::println);
                    break;
                case 0:
                    running = false;
                    System.out.println("Este gata!");
                    break;
                default:
                    System.out.println("Optiune invalida. Reincearca.");
            }
        }
    }
}
