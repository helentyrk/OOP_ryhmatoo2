public class Kontsert {
    private String kontserdiPealkiri;
    private String toimumiseKoht;
    private String toimumiseAeg;
    private int müüdavatePiletiteArv;
    private double piletiHind;

    public Kontsert(String kontserdiPealkiri, String toimumiseKoht, String toimumiseAeg, int müüdavatePiletiteArv, double piletiHind) {
        this.kontserdiPealkiri = kontserdiPealkiri;
        this.toimumiseKoht = toimumiseKoht;
        this.toimumiseAeg = toimumiseAeg;
        this.müüdavatePiletiteArv = müüdavatePiletiteArv;
        this.piletiHind = piletiHind;
    }

    @Override
    public String toString() {
        return "Kontserdile " + kontserdiPealkiri + " müüakse kokku " + müüdavatePiletiteArv + " piletit.";
    }
}
