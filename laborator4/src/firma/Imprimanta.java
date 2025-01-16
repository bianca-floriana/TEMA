package firma;

class Imprimanta extends Echipament {
    int ppm;
    String rezolutie;
    int paginiCartus;
    ModScriere modScriere;

    public Imprimanta(String denumire, int nrInv, double pret, char zonaMag, StareEchipament stare, int ppm, String rezolutie, int paginiCartus, ModScriere modScriere) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.paginiCartus = paginiCartus;
        this.modScriere = modScriere;
    }

    public Imprimanta() {
        super();
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getPaginiCartus() {
        return paginiCartus;
    }

    public void setPaginiCartus(int paginiCartus) {
        this.paginiCartus = paginiCartus;
    }

    public ModScriere getModScriere() {
        return modScriere;
    }

    public void setModScriere(ModScriere modScriere) {
        this.modScriere = modScriere;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("; %d; %s; %d; %s", ppm, rezolutie, paginiCartus, modScriere);
    }
}