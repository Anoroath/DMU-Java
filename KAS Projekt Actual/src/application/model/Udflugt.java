package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private String beskrivelse;
    private LocalDate dato;
    private double pris;
    private boolean inklusivFrokost;

    // associering dobbeltrettet 0 til mange til tilmeldning
    private ArrayList<Tilmeldning> tilmeldninger = new ArrayList<>();

    public Udflugt(String navn, String beskrivelse, LocalDate dato, double pris, boolean inklusivFrokost) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.pris = pris;
        this.inklusivFrokost = inklusivFrokost;
    }

    @Override
    public String toString() {
        String s = this.navn + ": " + this.beskrivelse + "\nDato: " + this.dato + "\nPris: " + this.pris;
        if (inklusivFrokost) {
            s += " -inklusiv frokost";
        }
        return s;
    }

    // -------------------------------------------------
    // Tilmeldning

    /**
     * tilføjer tilmeldning til udflugt pre-con: tilmeldningen må ikke have andre
     * udflugter
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

    // ---------------------------------------------------

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
     * @return the beskrivelse
     */
    public String getBeskrivelse() {
        return beskrivelse;
    }

    /**
     * @param beskrivelse
     *            the beskrivelse to set
     */
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    /**
     * @return the dato
     */
    public LocalDate getDato() {
        return dato;
    }

    /**
     * @param dato
     *            the dato to set
     */
    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    /**
     * @return the pris
     */
    public double getPris() {
        return pris;
    }

    /**
     * @param pris
     *            the pris to set
     */
    public void setPris(double pris) {
        this.pris = pris;
    }

    /**
     * @return the inklusivFrokost
     */
    public boolean isInklusivFrokost() {
        return inklusivFrokost;
    }

    /**
     * @param inklusivFrokost
     *            the inklusivFrokost to set
     */
    public void setInklusivFrokost(boolean inklusivFrokost) {
        this.inklusivFrokost = inklusivFrokost;
    }
}
