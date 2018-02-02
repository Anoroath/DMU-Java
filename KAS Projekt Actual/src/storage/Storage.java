package storage;

import java.util.ArrayList;

import application.model.Deltager;
import application.model.Konference;

public class Storage {

    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();

    // -----------------------------------------------------

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    // ----------------------------------------------------

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static void addDeltagere(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    // -----------------------------------------------------
}
