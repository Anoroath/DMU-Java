// Anders Broch Ulsted

package application.model;

import java.util.ArrayList;

public class Uddannelse {
    private String navn;
    private ArrayList<Hold> hold = new ArrayList<>();

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Uddannelse(String navn) {
        setNavn(navn);
    }

    public ArrayList<Hold> getHold() {
        return new ArrayList<>(hold);
    }

    public Hold createHold(String holdBetegnelse, String holdLeder) {
        Hold hold1 = new Hold(holdBetegnelse, holdLeder);
        hold.add(hold1);
        return hold1;
    }

    public void addHold(Hold hold2) {
        hold.add(hold2);
    }

    public void removeHold(Hold hold2) {
        hold.remove(hold2);
    }

    // public ArrayList<String> tutorOversigt(){
    // return ;
    // }
}
