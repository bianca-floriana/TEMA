package firma;

abstract class Echipament {
    String denumire;
    int nrInv;
    double pret;
    char zonaMag;
    StareEchipament stare;

    public Echipament(String denumire, int nrInv, double pret, char zonaMag, StareEchipament stare) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.zonaMag = zonaMag;
        this.stare = stare;
    }

    public Echipament() {
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrInv() {
        return nrInv;
    }

    public void setNrInv(int nrInv) {
        this.nrInv = nrInv;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public char getZonaMag() {
        return zonaMag;
    }

    public void setZonaMag(char zonaMag) {
        this.zonaMag = zonaMag;
    }

    public StareEchipament getStare() {
        return stare;
    }

    public void setStare(StareEchipament stare) {
        this.stare = stare;
    }



    @Override
    public String toString() {
        return String.format("%s; %d; %.2f; %c; %s", denumire, nrInv, pret, zonaMag, stare);
    }
}

