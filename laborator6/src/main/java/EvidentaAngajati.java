// Importurile necesare
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EvidentaAngajati {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


        List<Angajat> angajati = mapper.readValue(new File("C:\\Users\\Biu\\IdeaProjects\\laborator6\\src\\main\\java\\angajati.json"),
                new TypeReference<List<Angajat>>() {});


        System.out.println("Lista de angajați:");
        angajati.forEach(System.out::println);


        System.out.println("\nAngajați cu salariu peste 2500 RON:");
        angajati.stream()
                .filter(angajat -> angajat.getSalariu() > 2500)
                .forEach(System.out::println);


        int anulCurent = LocalDate.now().getYear();
        List<Angajat> conducereAprilie = angajati.stream()
                .filter(angajat -> angajat.getDataAngajarii().getYear() == anulCurent - 1 &&
                        angajat.getDataAngajarii().getMonth() == Month.APRIL &&
                        (angajat.getPost().toLowerCase().contains("șef") ||
                                angajat.getPost().toLowerCase().contains("director")))
                .collect(Collectors.toList());

        System.out.println("\nAngajați din luna aprilie a anului trecut, cu funcție de conducere:");
        conducereAprilie.forEach(System.out::println);


        System.out.println("\nAngajați fără funcție de conducere, ordonați descrescător după salariu:");
        angajati.stream()
                .filter(angajat -> !angajat.getPost().toLowerCase().contains("șef") &&
                        !angajat.getPost().toLowerCase().contains("director"))
                .sorted(Comparator.comparing(Angajat::getSalariu).reversed())
                .forEach(System.out::println);


        System.out.println("\nNume ale angajaților scrise cu majuscule:");
        List<String> numeMajuscule = angajati.stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .collect(Collectors.toList());
        numeMajuscule.forEach(System.out::println);


        System.out.println("\nSalarii mai mici de 3000 RON:");
        angajati.stream()
                .map(Angajat::getSalariu)
                .filter(salariu -> salariu < 3000)
                .forEach(System.out::println);


        System.out.println("\nPrimul angajat al firmei:");
        Optional<Angajat> primulAngajat = angajati.stream()
                .min(Comparator.comparing(Angajat::getDataAngajarii));
        primulAngajat.ifPresentOrElse(System.out::println,
                () -> System.out.println("Nu există angajați în firmă."));


        System.out.println("\nStatistici despre salarii:");
        var statistici = angajati.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariu));
        System.out.printf("Salariul mediu: %.2f\n", statistici.getAverage());
        System.out.printf("Salariul minim: %.2f\n", statistici.getMin());
        System.out.printf("Salariul maxim: %.2f\n", statistici.getMax());


        System.out.println("\nExistența unui angajat numit Ion:");
        angajati.stream()
                .map(Angajat::getNume)
                .filter(nume -> nume.equalsIgnoreCase("Ion"))
                .findAny()
                .ifPresentOrElse(
                        nume -> System.out.println("Firma are cel puțin un Ion angajat."),
                        () -> System.out.println("Firma nu are niciun Ion angajat."));


        System.out.println("\nNumărul de angajați din vara anului precedent:");
        long numarAngajatiVara = angajati.stream()
                .filter(angajat -> {
                    LocalDate data = angajat.getDataAngajarii();
                    return data.getYear() == anulCurent - 1 &&
                            (data.getMonth() == Month.JUNE ||
                                    data.getMonth() == Month.JULY ||
                                    data.getMonth() == Month.AUGUST);
                })
                .count();
        System.out.println(numarAngajatiVara);
    }
}
