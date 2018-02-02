package opgave4SodaCan;

public class SodaCan {

    private double h;
    private double d;

    public SodaCan(double h, double d) {
        this.h = h;
        this.d = d;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getH() {
        return this.h;
    }

    public double getD() {
        return this.d;
    }

    public double getVolume() {
        return Math.PI * h * ((d / 2) * (d / 2));
    }

    public double getSurfaceArea() {
        return 2 * Math.PI * (d / 2) * h + 2 * Math.PI * ((d / 2) * (d / 2));
    }
}
