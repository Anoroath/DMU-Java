package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String lokation;
    private LocalDate startDato;
    private LocalDate slutDato;
    private double kontigent;

    // Komposition enkelrettet 0 til mange til Udflugt
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    // Association enkeltrettet 0 til mange til Hotel
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    // Associering til 0 til mange til Tilmeldning
    private ArrayList<Tilmeldning> tilmeldninger = new ArrayList<>();

    public Konference(String navn, String lokation, LocalDate startDato, LocalDate slutDato, double kontigent) {
        this.navn = navn;
        this.lokation = lokation;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.kontigent = kontigent;
    }

    // ----------------------------------------------
    // Udflugt

    /**
     * Tilføjer udflugt til en konference
     *
     * @param udflugt
     */
    public Udflugt createUdflugt(String navn, String beskrivelse, LocalDate dato, double pris,
            boolean inklusivFrokost) {
        Udflugt u = new Udflugt(navn, beskrivelse, dato, pris, inklusivFrokost);
        this.udflugter.add(u);
        return u;
    }

    public void addUdflugt(Udflugt udflugt) {
        this.udflugter.add(udflugt);
    }

    public void removeUdflugt(Udflugt udflugt) {
        this.udflugter.remove(udflugt);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    // -----------------------------------------------
    // Hotel

    /**
     * Konstruerer hotel og tilføjer det til konferencen
     *
     * @param navn
     * @param prisPrNatEnkel
     * @param prisPrNatDobbelt
     * @return det nyoprettede hotel
     */
    public void addHotel(Hotel hotel) {
        this.hoteller.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        this.hoteller.remove(hotel);
    }

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    // ------------------------------------------------
    // Tilmeldning

    /**
     * Tilføjer en tilmeldning til en konference pre-con: tilmeldninger må ikke være
     * tilføjet andre konferencer
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

    // -------------------------------------------------

    @Override
    public String toString() {
        return this.navn + ", " + this.lokation + "\nStart: " + this.startDato + "\nSlut: " + this.slutDato;
    }

    public double getKontigent() {
        return this.kontigent;
    }

    public void setKontigent(double kontigent) {
        this.kontigent = kontigent;
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
}
