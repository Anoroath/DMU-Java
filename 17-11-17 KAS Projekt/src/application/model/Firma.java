package application.model;

public class Firma {
    public String firmaNavn;
    public String firmaTlfNr;

    public Firma(String firmaNavn, String firmaTlfNr) {
        this.firmaNavn = firmaNavn;
        this.firmaTlfNr = firmaTlfNr;
    }

    /**
     * @return the firmaNavn
     */
    public String getFirmaNavn() {
        return firmaNavn;
    }

    /**
     * @param firmaNavn
     *            the firmaNavn to set
     */
    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    /**
     * @return the firmaTlfNr
     */
    public String getFirmaTlfNr() {
        return firmaTlfNr;
    }

    /**
     * @param firmaTlfNr
     *            the firmaTlfNr to set
     */
    public void setFirmaTlfNr(String firmaTlfNr) {
        this.firmaTlfNr = firmaTlfNr;
    }

}
