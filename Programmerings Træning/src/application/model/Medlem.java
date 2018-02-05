package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobil;
    private String mail;
    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public Reservation createReservation(LocalDate dato, LocalTime startTid) {
        Reservation reservation = new Reservation(dato, startTid);
        reservationer.add(reservation);
        return reservation;
    }

    void addReservation(Reservation reservation) {
        reservationer.add(reservation);
        reservation.setMedlem(this);
    }

    void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
        reservation.setMedlem(null);
    }

    public Medlem(String navn, String mobil, String mail) {
        setNavn(navn);
        setMobil(mobil);
        setMail(mail);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
