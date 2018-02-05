package application.model;

import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneInfo;
    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
    }

    public Bane(int nummer, String baneInfo) {
        setNummer(nummer);
        setBaneInfo(baneInfo);
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getBaneInfo() {
        return baneInfo;
    }

    public void setBaneInfo(String baneInfo) {
        this.baneInfo = baneInfo;
    }

}
