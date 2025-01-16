package firma;

class SistemCalcul extends Echipament {
    String tipMonitor;
    double vitezaProcesor;
    int capacitateHDD;
    SistemOperare sistemOperare;

    public SistemCalcul(String denumire, int nrInv, double pret, char zonaMag, StareEchipament stare, String tipMonitor, double vitezaProcesor, int capacitateHDD, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMonitor = tipMonitor;
        this.vitezaProcesor = vitezaProcesor;
        this.capacitateHDD = capacitateHDD;
        this.sistemOperare = sistemOperare;
    }

    public SistemCalcul() {
        super();
    }

    public String getTipMonitor() {
        return tipMonitor;
    }

    public void setTipMonitor(String tipMonitor) {
        this.tipMonitor = tipMonitor;
    }

    public double getVitezaProcesor() {
        return vitezaProcesor;
    }

    public void setVitezaProcesor(double vitezaProcesor) {
        this.vitezaProcesor = vitezaProcesor;
    }

    public int getCapacitateHDD() {
        return capacitateHDD;
    }

    public void setCapacitateHDD(int capacitateHDD) {
        this.capacitateHDD = capacitateHDD;
    }

    public SistemOperare getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("; %s; %.2f; %d; %s", tipMonitor, vitezaProcesor, capacitateHDD, sistemOperare);
    }
}