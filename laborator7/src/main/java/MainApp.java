import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();


        Map<Integer, Carte> carti = mapper.readValue(
                new File("C:\\Users\\Biu\\IdeaProjects\\laborator7\\src\\main\\java\\carti.json"),
                new TypeReference<HashMap<Integer, Carte>>() {}
        );


        System.out.println("Colecția de cărți:");
        carti.forEach((id, carte) -> System.out.printf("%d: %s%n", id, carte));


        int idDeSters = 2;
        carti.remove(idDeSters);
        System.out.printf("\nCartea cu ID-ul %d a fost ștearsă.%n", idDeSters);


        int idNou = 7;
        Carte carteNoua = new Carte("Cartea Nouă", "Autor Nou", 2023);
        carti.putIfAbsent(idNou, carteNoua);
        System.out.printf("\nCartea adăugată: %s%n", carteNoua);


        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/carti.json"), carti);
        System.out.println("\nModificările au fost salvate în fișierul JSON.");


        Set<Carte> cartiYuval = carti.values().stream()
                .filter(carte -> carte.getAutorul().equals("Yuval Noah Harari"))
                .collect(Collectors.toSet());

        System.out.println("\nCărțile autorului Yuval Noah Harari:");
        cartiYuval.forEach(System.out::println);


        System.out.println("\nCărțile ordonate după titlu:");
        cartiYuval.stream()
                .sorted(Comparator.comparing(Carte::getTitlul))
                .forEach(System.out::println);


        System.out.println("\nCea mai veche carte:");
        cartiYuval.stream()
                .min(Comparator.comparing(Carte::getAnul))
                .ifPresentOrElse(
                        carte -> System.out.println("Cea mai veche carte este: " + carte),
                        () -> System.out.println("Nu există cărți în colecție."));
    }
}
