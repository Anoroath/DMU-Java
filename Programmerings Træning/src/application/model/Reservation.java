package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private LocalDate dato;
    private LocalTime startTid;
    private Medlem medlem;
    private Bane bane;

    public Bane getBane() {
        return bane;
    }

    public void setBane(Bane bane) {
        if (bane != null) {
            bane.addReservation(this);
        } else {
            this.bane.removeReservation(this);
        }
        this.bane = bane;
    }

    public Reservation(LocalDate dato, LocalTime startTid) {
        setDato(dato);
        setStartTid(startTid);
    }

    public Medlem getMedlem() {
        return medlem;
    }

    void setMedlem(Medlem medlem) {
        this.medlem = medlem;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public void setStartTid(LocalTime startTid) {
        this.startTid = startTid;
    }

}
