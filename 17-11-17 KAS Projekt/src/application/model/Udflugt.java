package application.model;

import java.time.LocalDate;

public class Udflugt {
    public String navn;
    public String beskrivelse;
    public LocalDate dato;
    public double pris;
    public boolean inklusivFrokost;

    public Udflugt(String navn, String beskrivelse, LocalDate dato, double pris, boolean inklusivFrokost) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.pris = pris;
        this.inklusivFrokost = inklusivFrokost;
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
