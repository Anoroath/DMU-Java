package application.model;

public class Tillæg {
    private String navn;
    private double prisPrNat;

    public Tillæg(String navn, double prisPrNat) {
        this.navn = navn;
        this.prisPrNat = prisPrNat;
    }

    @Override
    public String toString() {
        return this.navn + " - Pris pr. nat: " + this.prisPrNat;
    }

    /**
     * @return the navn
     */
    public String getNavn() {
        return navn;
    }

    /**
     * @param navn
     *            the navn to set
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * @return the prisPrNat
     */
    public double getPrisPrNat() {
        return prisPrNat;
    }

    /**
     * @param prisPrNat
     *            the prisPrNat to set
     */
    public void setPrisPrNat(double prisPrNat) {
        this.prisPrNat = prisPrNat;
    }
}
