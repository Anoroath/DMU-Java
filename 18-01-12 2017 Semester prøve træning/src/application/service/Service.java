package application.service;

import java.time.LocalDateTime;
import java.util.Collections;

import application.model.Arrangement;
import application.model.KonsolPlads;
import application.model.Område;
import application.model.Plads;
import application.model.Reservation;
import storage.Storage;

public class Service {

    public static Arrangement createArrangementer(String navn, boolean offentlig) {
        Arrangement arrangement = new Arrangement(navn, offentlig);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
        Reservation reservation = new Reservation(start, slut);
        return reservation;
    }

    public static Plads createPladser(int nr, Område område) {
        Plads plads = new Plads(nr, område);
        return plads;
    }

    public static void pladsTilReservation(Reservation reservation, Plads plads) {
        reservation.getPladser().add(plads);
    }

    public static void arrangementTilReservation(Reservation reservation, Arrangement arrangement) {
        arrangement.addReservation(reservation);
    }

    public static void initStorage() {
        Plads p1 = new Plads(1, Område.TURNERING);
        Plads p2 = new Plads(2, Område.TURNERING);
        Plads p3 = new Plads(3, Område.STANDARD);
        Plads p4 = new Plads(4, Område.STANDARD);
        Plads p5 = new Plads(5, Område.BØRNE);
        KonsolPlads kp1 = new KonsolPlads("PlayStation4", 1, Område.VIP);
        KonsolPlads kp2 = new KonsolPlads("Xbox One", 2, Område.VIP);
        Arrangement dota = new Arrangement("Dota 2 tournament", true);
        Arrangement csgo = new Arrangement("CS GO tournament", false);
        Reservation r1 = new Reservation(LocalDateTime.of(2017, 8, 12, 20, 00), LocalDateTime.of(2017, 8, 14, 23, 00));
        pladsTilReservation(r1, p1);
        pladsTilReservation(r1, p2);
        arrangementTilReservation(r1, dota);
        Reservation r2 = new Reservation(LocalDateTime.of(2017, 8, 13, 19, 00), LocalDateTime.of(2017, 8, 14, 6, 00));
        pladsTilReservation(r2, p3);
        pladsTilReservation(r2, p4);
        Reservation r3 = new Reservation(LocalDateTime.of(2017, 8, 14, 19, 00), LocalDateTime.of(2017, 8, 15, 6, 00));
        pladsTilReservation(r3, kp2);
    }

    public static Plads findPLads(Område område, int nummer) {
        Collections.sort(Storage.getPladser());
        boolean found = false;
        int left = 0;
        int right = Storage.getPladser().size() - 1;
        Plads plads = null;
        while (!found && left <= right) {
            int middle = (left + right) / 2;
            plads = Storage.getPladser().get(middle);
            int comp1 = plads.getOmråde().compareTo(område);
            int comp2 = plads.getNr() - nummer;
            if (comp1 == 0 && comp2 == 0) {
                found = true;
            } else if (comp1 > 0) {
                right = middle - 1;
            } else if (comp2 > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (found) {
            return plads;
        } else {
            return null;
        }
    }
}
