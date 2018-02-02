package application.model;

public class Firma {
    private String firmanavn;
    private String firmaTlfnr;

    public Firma(String firmanavn, String firmaTlfnr) {
        this.firmanavn = firmanavn;
        this.firmaTlfnr = firmaTlfnr;
    }

    @Override
    public String toString() {
        return "Firma: " + this.firmanavn + " Tlfnr: " + this.firmaTlfnr;
    }

    /**
     * @return the firmanavn
     */
    public String getFirmanavn() {
        return firmanavn;
    }

    /**
     * @param firmanavn
     *            the firmanavn to set
     */
    public void setFirmanavn(String firmanavn) {
        this.firmanavn = firmanavn;
    }

    /**
     * @return the firmaTlfnr
     */
    public String getFirmaTlfnr() {
        return firmaTlfnr;
    }

    /**
     * @param firmaTlfnr
     *            the firmaTlfnr to set
     */
    public void setFirmaTlfnr(String firmaTlfnr) {
        this.firmaTlfnr = firmaTlfnr;
    }

}
