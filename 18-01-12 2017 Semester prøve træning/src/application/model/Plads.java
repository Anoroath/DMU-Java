package application.model;

import java.util.ArrayList;

public class Plads implements Comparable<Plads> {
    private int nr;
    protected Område område;
    private ArrayList<Reservation> reservationer = new ArrayList<>();
    private static int standardTimePris = 50;

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
        reservation.addPlads(this);
    }

    public void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
        reservation.removePlads(null);
    }

    public Plads(int nr, Område område) {
        setNr(nr);
        setOmråde(område);
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Område getOmråde() {
        return område;
    }

    public void setOmråde(Område område) {
        this.område = område;
    }

    public static int getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(int standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }

    public double pris(int timer) {
        if (this.område.equals(Område.VIP)) {
            return (standardTimePris * 1.25) * timer;
        } else if (this.område.equals(Område.BØRNE)) {
            return (standardTimePris * 0.8) * timer;
        } else if (this.område.equals(Område.TURNERING)) {
            return (standardTimePris * 1.1) * timer;
        } else {
            return standardTimePris * timer;
        }
    }

    @Override
    public int compareTo(Plads o) {
        if (this.område.compareTo(o.område) == 0) {
            return getNr() - o.getNr();
        } else {
            return this.område.ordinal() - o.område.ordinal();
        }
    }
}
