package application.service;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Tillæg;
import application.model.Tilmeldning;
import application.model.Udflugt;
import storage.Storage;

public class Service {

    // -------------------------------------------------------------------
    // Konference

    /**
     * Returnerer alle konferencer
     */
    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }

    public static ArrayList<Deltager> getDeltagereKonference(Konference konference) {
        ArrayList<Deltager> deltager = new ArrayList<>();

        for (Tilmeldning t : konference.getTilmeldninger()) {
            deltager.add(t.getDeltager());
        }
        return deltager;
    }

    public static ArrayList<Hotel> getHoteller(Konference konference) {
        return new ArrayList<>(konference.getHoteller());
    }

    public static ArrayList<String> getHotelGæster(Hotel hotel) {
        ArrayList<String> gæster = new ArrayList<>();
        for (Tilmeldning t : hotel.getTilmeldninger()) {
            if (t.getLedsager() != null) {
                gæster.add(t.getDeltager() + " (" + t.getLedsager() + ")");
            } else {
                gæster.add(t.getDeltager().toString());
            }
        }
        return gæster;
    }

    public static ArrayList<Udflugt> getUdflugter(Konference konference) {
        return new ArrayList<>(konference.getUdflugter());
    }

    public static ArrayList<Ledsager> getUdflugtTilmeldt(Udflugt udflugt) {
        ArrayList<Ledsager> ledsager = new ArrayList<>();

        for (Tilmeldning t : udflugt.getTilmeldninger()) {
            ledsager.add(t.getLedsager());
        }
        return ledsager;
    }

    public static ArrayList<Tillæg> getTillæg(Hotel hotel) {
        return new ArrayList<>(hotel.getTillæg());
    }

    // ------------------------------------------------------------------
    // Deltager
    /**
     * Opretter en deltager
     *
     * @param fornavn
     * @param efternavn
     * @param adresse
     * @param tlfnr
     * @param by_land
     * @return nyoprettet deltager
     */
    public static Deltager createDeltager(String fornavn, String efternavn, String adresse, String tlfnr,
            String by_land) {
        Deltager d = new Deltager(fornavn, efternavn, adresse, tlfnr, by_land);
        Storage.addDeltagere(d);
        return d;
    }

    public static void deleteDeltager(Deltager deltager) {
        for (Tilmeldning t : deltager.getTilmeldninger()) {
            for (Udflugt u : t.getUdflugter()) {
                t.removeUdflugt(u);
            }
            t.setKonference(null);
            t.setHotel(null);
            t.setDeltager(null);
        }
        Storage.removeDeltager(deltager);
    }

    public static void updateDeltager(Deltager deltager, String fornavn, String efternavn, String adresse, String tlfnr,
            String by_land) {
        deltager.setFornavn(fornavn);
        deltager.setEfternavn(efternavn);
        deltager.setAdresse(adresse);
        deltager.setTlfnr(tlfnr);
        deltager.setBy_land(by_land);
    }

    // -------------------------------------------------------------------
    // tilmeldning

    public static Tilmeldning createTilmeldning(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder,
            Deltager deltager, Konference konference) {
        Tilmeldning tilmeldning = new Tilmeldning(ankomstDato, afrejseDato, foredragsholder, deltager, konference);
        return tilmeldning;
    }

    public static void deleteTilmeldning(Tilmeldning tilmeldning) {
        tilmeldning.setDeltager(null);
        for (Udflugt u : tilmeldning.getUdflugter()) {
            tilmeldning.removeUdflugt(u);
        }
        tilmeldning.setKonference(null);
        tilmeldning.setHotel(null);
    }

    // ----------------------------------------------------------------------
    // ledsager

    public static void addLedsagerTilTilmeldning(Tilmeldning tilmeldning, String fornavn, String efternavn) {
        tilmeldning.createLedsager(fornavn, efternavn);
    }

    public static void removeLedsagerFraTilmeldning(Tilmeldning tilmeldning) {
        tilmeldning.deleteLedsager();
    }

    // -----------------------------------------------------------------------
    // firma

    public static void addFirmaTilTilmeldning(Tilmeldning tilmeldning, String firmaNavn, String firmaTlfnr) {
        tilmeldning.createFirma(firmaNavn, firmaTlfnr);
    }

    public static void removeFirmaFraTilmeldning(Tilmeldning tilmeldning) {
        tilmeldning.setFirma(null);
    }

    // ------------------------------------------------------------------------

    public static double udregnPris(Tilmeldning tilmeldning) {
        return tilmeldning.samletPris();
    }

    public static void initStorage() {

        Konference k1 = new Konference("Hav", "Odense", LocalDate.of(2017, 12, 1), LocalDate.of(2017, 12, 3), 1500);
        Udflugt udOdense = new Udflugt("HCA's hus", "Se et gammelt hus", LocalDate.of(2017, 12, 2), 200, true);
        k1.addUdflugt(udOdense);

        Konference k2 = new Konference("Himmel", "Århus", LocalDate.of(2017, 12, 4), LocalDate.of(2017, 12, 6), 1500);
        Udflugt udAarhus = new Udflugt("Letbanen", "Et evighedsprojekt?", LocalDate.of(2017, 12, 4), 30, false);
        Udflugt udAarhus2 = new Udflugt("Aros", "En masse kunst", LocalDate.of(2017, 12, 5), 150, true);
        k2.addUdflugt(udAarhus);
        k2.addUdflugt(udAarhus2);

        Hotel h1 = new Hotel("Den Hvide Svane", 1050, 1250);
        Tillæg tillæg1 = h1.createTillæg("WiFi", 50);
        Tillæg tillæg2 = h1.createTillæg("Aftenkaffe", 100);

        Hotel h2 = new Hotel("Hotel Phønix", 1200, 1500);
        h2.createTillæg("TV", 40);

        k1.addHotel(h1);
        k1.addHotel(h2);

        Hotel h3 = new Hotel("Hotel Skovly", 900, 1100);
        h3.createTillæg("Søudsigt", 100);

        k2.addHotel(h3);

        Deltager d1 = new Deltager("Anna", "Krogh", "Ghettoen", "1548454318", "Danmark");
        Deltager d2 = new Deltager("Katja", "Mangelsen", "FlurStraße 13", "+496848582100", "Flensborg, Tyskland");
        Deltager d3 = new Deltager("Frederik", "Andersen", "Lærkevej 4", "75487652", "København, Danmark");

        Tilmeldning til1 = Service.createTilmeldning(LocalDate.of(2017, 12, 1), LocalDate.of(2017, 12, 3), false, d1,
                k1);
        til1.createLedsager("Maria", "Pedersen");
        til1.setHotel(h1);
        til1.addTillæg(tillæg1);
        til1.addTillæg(tillæg2);
        til1.addUdflugt(udOdense);

        Tilmeldning til2 = Service.createTilmeldning(LocalDate.of(2017, 12, 1), LocalDate.of(2017, 12, 3), false, d1,
                k2);
        til2.setHotel(h3);
        til2.createLedsager("Ole", "Olesen");
        til2.addUdflugt(udAarhus2);
        til2.addUdflugt(udAarhus);

        Tilmeldning til3 = Service.createTilmeldning(LocalDate.of(2017, 12, 1), LocalDate.of(2017, 12, 3), false, d2,
                k1);
        til3.createLedsager("Marc", "Pfnister");
        til3.createFirma("Kindergarten", "+492548962345");
        til3.setHotel(h1);
        til3.addUdflugt(udAarhus2);

        Storage.addKonference(k1);
        Storage.addKonference(k2);
        Storage.addDeltagere(d1);
        Storage.addDeltagere(d2);
        Storage.addDeltagere(d3);

    }
}
