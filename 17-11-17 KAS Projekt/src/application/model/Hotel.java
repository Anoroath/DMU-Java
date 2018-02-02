package application.model;

public class Hotel {
    public String hotelNavn;
    public double prisPrNatDobblet;
    public double prisPrNatEnkelt;

    public Hotel(String hotelNavn, double prisPrNatDobblet, double prisPrNatEnkelt) {
        this.hotelNavn = hotelNavn;
        this.prisPrNatDobblet = prisPrNatDobblet;
        this.prisPrNatEnkelt = prisPrNatEnkelt;
    }

    /**
     * @return the hotelNavn
     */
    public String getHotelNavn() {
        return hotelNavn;
    }

    /**
     * @param hotelNavn
     *            the hotelNavn to set
     */
    public void setHotelNavn(String hotelNavn) {
        this.hotelNavn = hotelNavn;
    }

    /**
     * @return the prisPrNatDobblet
     */
    public double getPrisPrNatDobblet() {
        return prisPrNatDobblet;
    }

    /**
     * @param prisPrNatDobblet
     *            the prisPrNatDobblet to set
     */
    public void setPrisPrNatDobblet(double prisPrNatDobblet) {
        this.prisPrNatDobblet = prisPrNatDobblet;
    }

    /**
     * @return the prisPrNatEnkelt
     */
    public double getPrisPrNatEnkelt() {
        return prisPrNatEnkelt;
    }

    /**
     * @param prisPrNatEnkelt
     *            the prisPrNatEnkelt to set
     */
    public void setPrisPrNatEnkelt(double prisPrNatEnkelt) {
        this.prisPrNatEnkelt = prisPrNatEnkelt;
    }
}
