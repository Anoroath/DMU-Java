package application.model;

import java.time.LocalDate;

public class Konference {
    public String navn;
    public String lokation;
    public LocalDate startDato;
    public LocalDate slutDato;
    public int kontingent;

    public Konference(String navn, String lokation, LocalDate startDato, LocalDate slutDato, int kontingent) {
        this.navn = navn;
        this.lokation = lokation;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.kontingent = kontingent;
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
     * @return the lokation
     */
    public String getLokation() {
        return lokation;
    }

    /**
     * @param lokation
     *            the lokation to set
     */
    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    /**
     * @return the startDato
     */
    public LocalDate getStartDato() {
        return startDato;
    }

    /**
     * @param startDato
     *            the startDato to set
     */
    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    /**
     * @return the slutDato
     */
    public LocalDate getSlutDato() {
        return slutDato;
    }

    /**
     * @param slutDato
     *            the slutDato to set
     */
    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    /**
     * @return the kontingent
     */
    public int getKontingent() {
        return kontingent;
    }

    /**
     * @param kontingent
     *            the kontingent to set
     */
    public void setKontingent(int kontingent) {
        this.kontingent = kontingent;
    }
}
