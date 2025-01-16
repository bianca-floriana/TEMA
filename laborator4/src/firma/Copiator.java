package firma;

class Copiator extends Echipament {
    int paginiToner;
    FormatCopiere formatCopiere;

    public Copiator(String denumire, int nrInv, double pret, char zonaMag, StareEchipament stare, int paginiToner, FormatCopiere formatCopiere) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.paginiToner = paginiToner;
        this.formatCopiere = formatCopiere;
    }

    public Copiator() {
        super();
    }

    public int getPaginiToner() {
        return paginiToner;
    }

    public void setPaginiToner(int paginiToner) {
        this.paginiToner = paginiToner;
    }

    public FormatCopiere getFormatCopiere() {
        return formatCopiere;
    }

    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return String.format("%s; %d; %.2f; %c; %s", denumire, nrInv, pret, zonaMag, stare);
    }
}