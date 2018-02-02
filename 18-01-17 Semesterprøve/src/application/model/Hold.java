// Anders Broch Ulsted

package application.model;

import java.util.ArrayList;

public class Hold {
    private String betegnelse;
    private String holdleder;
    private ArrayList<Tutor> tutorer = new ArrayList<>();
    private Uddannelse uddannelse;

    public String getBetegnelse() {
        return betegnelse;
    }

    public void setBetegnelse(String betegnelse) {
        this.betegnelse = betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public void setHoldleder(String holdleder) {
        this.holdleder = holdleder;
    }

    public Hold(String betegnelse, String holdleder) {
        setBetegnelse(betegnelse);
        setHoldleder(holdleder);
    }

    public ArrayList<Tutor> getTutor() {
        return new ArrayList<>(tutorer);
    }

    public void addTutor(Tutor tutor) {
        tutorer.add(tutor);
        tutor.setHold(this);
    }

    public void removeTutor(Tutor tutor) {
        tutorer.remove(tutor);
        tutor.setHold(null);
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    void setUddannelse(Uddannelse uddannelse) {
        this.uddannelse = uddannelse;
    }

    public boolean harTidsoverlap(Arrangement arrangement) {
        for (Tutor t : tutorer) {
            for (Arrangement a : t.getArrangementer()) {
                if (arrangement.getStartTid().isAfter(a.getSlutTid())
                        || arrangement.getSlutTid().isBefore(a.getStartTid())) {
                    return true;
                }
            }
        }
        return false;
    }
}
