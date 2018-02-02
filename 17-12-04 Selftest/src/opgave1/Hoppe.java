package opgave1;

public class Hoppe extends Hest {
    private int antalFøl;

    public Hoppe(String navn, int fødselsår)

    public int getAntalFøl() {
        return antalFøl;
    }

    public void setAntalFøl(int antalFøl) {
        this.antalFøl = antalFøl;
    }

    @Override
    public String toString() {
        return toString() + " " + antalFøl;
    }
}
