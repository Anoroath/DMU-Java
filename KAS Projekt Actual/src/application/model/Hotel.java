package application.model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private double prisPrNatEnkel;
    private double prisPrNatDobbelt;

    // Komposition enkelrettet 0 til mange til Tillæg
    private ArrayList<Tillæg> tillæg = new ArrayList<>();
    // associering dobbeltrettet 0 til mange til tilmeldning
    private ArrayList<Tilmeldning> tilmeldninger = new ArrayList<>();

    public Hotel(String navn, double prisPrNatEnkel, double prisPrNatDobbelt) {
        this.navn = navn;
        this.prisPrNatEnkel = prisPrNatEnkel;
        this.prisPrNatDobbelt = prisPrNatDobbelt;
    }

    @Override
    public String toString() {
        return this.navn + "\nPris enkelt/dobbelt værelse:\n" + this.prisPrNatEnkel + "/" + this.prisPrNatDobbelt
                + " kr";
    }

    // ----------------------------------------
    // Tillæg

    public Tillæg createTillæg(String navn, double prisPrNat) {
        Tillæg t = new Tillæg(navn, prisPrNat);
        this.tillæg.add(t);
        return t;
    }

    public void deleteTillæg(Tillæg tillæg) {
        this.tillæg.remove(tillæg);
    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    // ----------------------------------------
    // Tilmeldninger

    /**
     * tilføjer tilmeldning til hotel pre-con: tilmeldningen må ikke have andre
     * hoteller
     *
     * @param tilmeldning
     */
    void addTilmeldning(Tilmeldning tilmeldning) {
        this.tilmeldninger.add(tilmeldning);
    }

    void removeTilmeldning(Tilmeldning tilmeldning) {
        this.tilmeldninger.remove(tilmeldning);
    }

    public ArrayList<Tilmeldning> getTilmeldninger() {
        return new ArrayList<>(tilmeldninger);
    }

    // -----------------------------------------

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
     * @return the prisPrNatEnkel
     */
    public double getPrisPrNatEnkel() {
        return prisPrNatEnkel;
    }

    /**
     * @param prisPrNatEnkel
     *            the prisPrNatEnkel to set
     */
    public void setPrisPrNatEnkel(double prisPrNatEnkel) {
        this.prisPrNatEnkel = prisPrNatEnkel;
    }

    /**
     * @return the prisPrNatDobbelt
     */
    public double getPrisPrNatDobbelt() {
        return prisPrNatDobbelt;
    }

    /**
     * @param prisPrNatDobbelt
     *            the prisPrNatDobbelt to set
     */
    public void setPrisPrNatDobbelt(double prisPrNatDobbelt) {
        this.prisPrNatDobbelt = prisPrNatDobbelt;
    }
}
