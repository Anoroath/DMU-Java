// Anders Broch Ulsted

package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Arrangement {
    private String titel;
    private LocalDate date;
    private LocalDateTime startTid;
    private LocalDateTime slutTid;
    private double pris;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStartTid() {
        return startTid;
    }

    public void setStartTid(LocalDateTime startTid) {
        this.startTid = startTid;
    }

    public LocalDateTime getSlutTid() {
        return slutTid;
    }

    public void setSlutTid(LocalDateTime slutTid) {
        this.slutTid = slutTid;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public Arrangement(String titel, LocalDate date, LocalDateTime startTid, LocalDateTime slutTid, double pris) {
        setTitel(titel);
        setDate(date);
        setStartTid(startTid);
        setSlutTid(slutTid);
        setPris(pris);
    }
}
