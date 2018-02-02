package application.model;

public class KonsolPlads extends Plads {
    private String type;

    public KonsolPlads(String type, int nr, Område område) {
        super(nr, område);
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double pris(int timer) {
        double pris = super.pris(timer);
        if (getOmråde().equals(Område.BØRNE)) {
            return pris * 1.1;
        } else {
            return pris * 1.25;
        }
    }

}
