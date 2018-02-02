package application.model;

import java.util.ArrayList;

public class Deltager extends Person {

    private String adresse;
    private String tlfnr;
    private String by_land;

    // associering dobbeltrettet 0 til mange til tilmeldning
    private ArrayList<Tilmeldning> tilmeldninger = new ArrayList<>();

    public Deltager(String fornavn, String efternavn, String adresse, String tlfnr, String by_land) {
        super(fornavn, efternavn);
        this.adresse = adresse;
        this.tlfnr = tlfnr;
        this.by_land = by_land;
    }

    // ----------------------------------------
    // Tilmeldning

    /**
     * tilføjer tilmeldning til deltager pre-con: tilmeldningen må ikke have andre
     * deltagere
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

    // ----------------------------------------

    @Override
    public String toString() {
        return getFornavn() + " " + getEfternavn();
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse
     *            the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the tlfnr
     */
    public String getTlfnr() {
        return tlfnr;
    }

    /**
     * @param tlfnr
     *            the tlfnr to set
     */
    public void setTlfnr(String tlfnr) {
        this.tlfnr = tlfnr;
    }

    /**
     * @return the by_land
     */
    public String getBy_land() {
        return by_land;
    }

    /**
     * @param by_land
     *            the by_land to set
     */
    public void setBy_land(String by_land) {
        this.by_land = by_land;
    }

}
