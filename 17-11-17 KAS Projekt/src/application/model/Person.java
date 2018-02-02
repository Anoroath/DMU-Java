package application.model;

public class Person {
    public String fornavn;
    public String efternavn;

    public Person(String fornavn, String efternavn) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    /**
     * @return the fornavn
     */
    public String getFornavn() {
        return fornavn;
    }

    /**
     * @param fornavn
     *            the fornavn to set
     */
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    /**
     * @return the efternavn
     */
    public String getEfternavn() {
        return efternavn;
    }

    /**
     * @param efternavn
     *            the efternavn to set
     */
    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }
}
