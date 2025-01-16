import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Mobilier> mobilierList = objectMapper.readValue(
                new File("C:\\Users\\Biu\\IdeaProjects\\labor5\\src\\main\\java\\mobilier.json"),
                new TypeReference<>() {}
        );

        System.out.println("Piese de mobilier:");
        mobilierList.forEach(System.out::println);

        String numeMobilier = "dulap 1"; // exemplu
        System.out.println("\nPlăci pentru piesa: " + numeMobilier);
        mobilierList.stream()
                .filter(mobilier -> mobilier.getNume().equalsIgnoreCase(numeMobilier))
                .flatMap(mobilier -> mobilier.getPlaci().stream())
                .forEach(System.out::println);


        System.out.println("\nNumăr estimativ de coli de PAL necesare pentru " + numeMobilier + ":");
        mobilierList.stream()
                .filter(mobilier -> mobilier.getNume().equalsIgnoreCase(numeMobilier))
                .flatMap(mobilier -> mobilier.getPlaci().stream())
                .mapToDouble(placa -> (placa.getLungime() * placa.getLatime() * placa.getNrBucati()) / (2800.0 * 2070))
                .sum();
    }
}

