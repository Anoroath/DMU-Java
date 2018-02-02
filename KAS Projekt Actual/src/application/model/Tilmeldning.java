package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.*;

public class Tilmeldning {
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private boolean foredragsholder;

    // aggregernig enkelrettet 0-1 til Firma
    private Firma firma;
    // komposition enkeltrettet 0-1 til Ledsager
    private Ledsager ledsager;
    // tvungen associering dobbeltrettet til Deltager
    private Deltager deltager;
    // associering dobbeltrettet 0 til mange til Udflugt
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    // tvungen associering dobbeltrettet til konference
    private Konference konference;
    // associering dobbeltrettet 0-1 til Hotel
    private Hotel hotel;
    // associering enkeltrettet 0 til mange til tillæg
    private ArrayList<Tillæg> tillæg = new ArrayList<>();

    public Tilmeldning(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder, Deltager deltager,
            Konference konference) {
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsholder = foredragsholder;
        this.deltager = deltager;
        deltager.addTilmeldning(this);
        this.konference = konference;
        konference.addTilmeldning(this);
    }

    @Override
    public String toString() {
        if (this.ledsager != null) {
            return this.konference + "\nPris: " + samletPris() + " kr\nLedsager: " + this.ledsager;
        } else {
            return this.konference + "\nPris: " + samletPris() + " kr";
        }
    }

    public double samletPris() {
        double sum = 0;

        if (!foredragsholder) {
            sum += this.konference.getKontigent() * (antalDage() + 1);
        }

        if (this.hotel != null) {
            if (this.ledsager != null) {
                sum += this.hotel.getPrisPrNatDobbelt() * antalDage();
            } else {
                sum += this.hotel.getPrisPrNatEnkel() * antalDage();
            }
            for (Tillæg t : tillæg) {
                sum += t.getPrisPrNat() * antalDage();
            }
        }

        if (this.ledsager != null) {
            for (Udflugt u : udflugter) {
                sum += u.getPris();
            }
        }

        return sum;
    }

    private int antalDage() {
        int daysBetween = (int) DAYS.between(this.ankomstDato, this.afrejseDato);
        return daysBetween;
    }

    // -------------------------------
    // Firma

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    /**
     * kontruerer firma og tilføjer det til Tilmeldning
     *
     * @param firmaNavn
     * @param firmaTlfnr
     * @return firma
     */
    public Firma createFirma(String firmaNavn, String firmaTlfnr) {
        Firma f = new Firma(firmaNavn, firmaTlfnr);
        this.firma = f;
        return f;
    }

    public Firma getFirma() {
        return this.firma;
    }
    // --------------------------------
    // Ledsager

    /**
     * konstruerer ledsager og tilføjer den til tilmeldningen
     *
     * @param fornavn
     * @param efternavn
     * @return
     */
    public Ledsager createLedsager(String fornavn, String efternavn) {
        Ledsager led = new Ledsager(fornavn, efternavn);
        this.ledsager = led;
        return led;
    }

    public void deleteLedsager() {
        this.ledsager = null;
    }

    public Ledsager getLedsager() {
        return this.ledsager;
    }
    // ---------------------------------
    // deltager

    public void setDeltager(Deltager deltager) {
        if (this.deltager != null) {
            this.deltager.removeTilmeldning(this);
            this.deltager = null;
        }
        if (deltager != null) {
            this.deltager = deltager;
            deltager.addTilmeldning(this);
        }
    }

    public Deltager getDeltager() {
        return this.deltager;
    }

    // ----------------------------------
    // udflugt

    /**
     * tilføjer udflugt til tilmeldning pre-con: udflugt har ikke en tilmeldning
     *
     * @param udflugt
     */
    public void addUdflugt(Udflugt udflugt) {
        this.udflugter.add(udflugt);
        udflugt.addTilmeldning(this);
    }

    public void removeUdflugt(Udflugt udflugt) {
        this.udflugter.add(udflugt);
        udflugt.removeTilmeldning(this);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    // -----------------------------------
    // konference

    public void setKonference(Konference konference) {
        if (this.konference != null) {
            this.konference.removeTilmeldning(this);
            this.konference = null;
        }
        if (konference != null) {
            this.konference = konference;
            konference.addTilmeldning(this);
        }
    }

    public Konference getKonference() {
        return this.konference;
    }

    // -------------------------------------
    // hotel

    /**
     * tilføjer et hotel til tilmeldningen hotel kan godt være null
     *
     * @param hotel
     */
    public void setHotel(Hotel hotel) {
        if (this.hotel != null) {
            this.hotel.removeTilmeldning(this);
            this.hotel = null;
        }
        if (hotel != null) {
            this.hotel = hotel;
            hotel.addTilmeldning(this);
        }
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    // --------------------------------------
    // tillæg

    /**
     * tilføjer tillæg til tilmeldningen pre-con: der skal være tilføjet et hotel
     *
     * @param tillæg
     */
    public void addTillæg(Tillæg tillæg) {
        this.tillæg.add(tillæg);
    }

    public void removetillæg(Tillæg tillæg) {
        this.tillæg.remove(tillæg);
    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }
    // --------------------------------------

    /**
     * @return the ankomstDato
     */
    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    /**
     * @param ankomstDato
     *            the ankomstDato to set
     */
    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    /**
     * @return the afrejseDato
     */
    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    /**
     * @param afrejseDato
     *            the afrejseDato to set
     */
    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    /**
     * @return the foredragsholder
     */
    public boolean isForedragsholder() {
        return foredragsholder;
    }

    /**
     * @param foredragsholder
     *            the foredragsholder to set
     */
    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }
}
