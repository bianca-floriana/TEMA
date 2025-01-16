
public class Carte {
    private String titlul;
    private String autorul;
    private int anul;


    public Carte() {
    }


    public Carte(String titlul, String autorul, int anul) {
        this.titlul = titlul;
        this.autorul = autorul;
        this.anul = anul;
    }

    public String getTitlul() {
        return titlul;
    }

    public String getAutorul() {
        return autorul;
    }

    public int getAnul() {
        return anul;
    }

    public void setTitlul(String titlul) {
        this.titlul = titlul;
    }

    public void setAutorul(String autorul) {
        this.autorul = autorul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }


    @Override
    public String toString() {
        return "Carte{" +
                "titlul='" + titlul + '\'' +
                ", autorul='" + autorul + '\'' +
                ", anul=" + anul +
                '}';
    }
}