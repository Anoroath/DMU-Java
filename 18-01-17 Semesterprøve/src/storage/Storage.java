// Anders Broch Ulsted

package storage;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Hold;
import application.model.Tutor;
import application.model.Uddannelse;

public class Storage {
    private static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static ArrayList<Hold> hold1 = new ArrayList<>();
    private static ArrayList<Tutor> tutorer = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    // ----------------------------------------------------------------------------------------------------------------

    public static ArrayList<Uddannelse> getUddannelser() {
        return new ArrayList<>(uddannelser);
    }

    public static void addUddannelse(Uddannelse uddannelse) {
        uddannelser.add(uddannelse);
    }

    public static void removeUddannelse(Uddannelse uddannelse) {
        uddannelser.remove(uddannelse);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public static ArrayList<Hold> getHold() {
        return new ArrayList<>(hold1);
    }

    public static void addHold(Hold hold) {
        hold1.add(hold);
    }

    public static void removeHold(Hold hold) {
        hold1.remove(hold);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public static ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(tutorer);
    }

    public static void addTutor(Tutor tutor) {
        tutorer.add(tutor);
    }

    public static void removeTutor(Tutor tutor) {
        tutorer.remove(tutor);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public static void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }
}
