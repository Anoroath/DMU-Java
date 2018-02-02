package opgave1;

public class Hest {
    public String navn;
    public int fødselsår;

    public Hest(String navn, int fødselsår) {
        setName(navn);
        setFødselsår(fødselsår);
    }

    public String getName() {
        return navn;
    }

    public void setName(String name) {
        this.navn = name;
    }

    public int getFødselsår() {
        return fødselsår;
    }

    public void setFødselsår(int fødselsår) {
        this.fødselsår = fødselsår;
    }

    @Override
    public String toString() {
        return navn + " " + fødselsår;
    }
}
