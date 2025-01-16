package p4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Persoana {
    private String nume;
    private String cnp;

    // Constructor
    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    // Getteri
    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    // Metoda pentru calcularea vârstei
    public int getVarsta() {
        // Extragem anul, luna și ziua din CNP
        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        // Determinăm secolul pe baza primei cifre din CNP
        int secol;
        switch (cnp.charAt(0)) {
            case '1': case '2':
                secol = 1900;
                break;
            case '5': case '6':
                secol = 2000;
                break;
            default:
                throw new IllegalArgumentException("CNP invalid!");
        }
        an += secol;

        // Calculăm data nașterii
        LocalDate dataNasterii = LocalDate.of(an, luna, zi);
        LocalDate dataCurenta = LocalDate.now();

        // Calculăm vârsta
        return (int) ChronoUnit.YEARS.between(dataNasterii, dataCurenta);
    }
}
