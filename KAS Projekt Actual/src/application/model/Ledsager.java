package application.model;

public class Ledsager extends Person {

    public Ledsager(String fornavn, String efternavn) {
        super(fornavn, efternavn);
    }

    @Override
    public String toString() {
        return getFornavn() + " " + getEfternavn();
    }

}
