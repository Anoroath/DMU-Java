package opgave1;

public class Kunde implements Comparable<Kunde> {
    private String efternavn;
    private String fornavn;
    private int alder;

    public Kunde(String efternavn, String fornavn, int alder) {
        this.efternavn = efternavn;
        this.fornavn = fornavn;
        this.alder = alder;
    }

    @Override
    public int compareTo(Kunde kunde) {
        if (!efternavn.equals(kunde.getEfternavn())) {
            return efternavn.compareTo(kunde.getEfternavn());
        } else {
            return fornavn.compareTo(kunde.getFornavn());
        }
    }

    public int getAlder() {
        return alder;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    @Override
    public String toString() {
        return efternavn + " " + fornavn + " " + alder;
    }
}