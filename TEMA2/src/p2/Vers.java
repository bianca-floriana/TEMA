package p2;

class Vers {
    private String vers;

    // Constructor
    public Vers(String vers) {
        this.vers = vers;
    }

    // Metodă pentru a obține numărul de cuvinte din vers
    public int getNrCuvinte() {
        if (vers == null || vers.trim().isEmpty()) {
            return 0;
        }
        return vers.trim().split("\\s+").length;
    }

    // Metodă pentru a obține numărul de vocale din vers
    public int getNrVocale() {
        int count = 0;
        for (char c : vers.toLowerCase().toCharArray()) {
            if ("aeiouăâî".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Metodă pentru a verifica dacă versul se termină cu o anumită grupare de litere
    public boolean seTerminaCu(String grupare) {
        return vers.endsWith(grupare);
    }

    // Metodă pentru a obține versul în majuscule
    public String getVersCuMajuscule() {
        return vers.toUpperCase();
    }

    // Metodă pentru a returna versul original
    public String getVers() {
        return vers;
    }
}