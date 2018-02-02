// Anders Broch Ulsted

package application.model;

import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;
    private Hold hold;
    public ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tutor(String navn, String email) {
        setNavn(navn);
        setEmail(email);
    }

    public Hold getHold() {
        return hold;
    }

    void setHold(Hold hold) {
        this.hold = hold;
    }

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }

    // public double arrangementsPris(Arrangement arrangement) {
    // ArrayList<Arrangement> antal = new ArrayList<>();
    // for (Arrangement a : arrangement.getPris()) {
    // }
}
