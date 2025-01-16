package exemplul1;
//e tot lab5

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(5, 8));
        lista.add(new PerecheNumere(13, 21));
        lista.add(new PerecheNumere(2, 3));

        scriere(lista);

        List<PerecheNumere> listaIncarcata = citire();
        System.out.println(listaIncarcata);
    }

    public static void scriere(List<PerecheNumere> lista) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("perechi.json"), lista);
            System.out.println("Datele au fost salvate în perechi.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("perechi.json"), new TypeReference<List<PerecheNumere>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

