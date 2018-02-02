package application.model;

public class Deltager extends Person {
    public String adresse;
    public String tlfnr;
    public String by_Land;

    public Deltager(String fornavn, String efternavn, String adresse, String tlfnr, String by_Land) {
        super(fornavn, efternavn);
        this.adresse = adresse;
        this.tlfnr = tlfnr;
        this.by_Land = by_Land;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse
     *            the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the tlfnr
     */
    public String getTlfnr() {
        return tlfnr;
    }

    /**
     * @param tlfnr
     *            the tlfnr to set
     */
    public void setTlfnr(String tlfnr) {
        this.tlfnr = tlfnr;
    }

    /**
     * @return the by_Land
     */
    public String getBy_Land() {
        return by_Land;
    }

    /**
     * @param by_Land
     *            the by_Land to set
     */
    public void setBy_Land(String by_Land) {
        this.by_Land = by_Land;
    }

}
