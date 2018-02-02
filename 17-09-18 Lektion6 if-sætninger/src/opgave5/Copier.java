package opgave5;

public class Copier {
    private boolean paperStuck;
    private int paper;

    public Copier() {

    }

    public void insertPaper(int paper) {
        if (this.paper + paper <= 500) {
            this.paper = paper;

        } else {
            System.out.println("Error, max capacity 500 pieces");

        }
    }

    public int getPaper() {
        return this.paper;
    }

    public void makeCopy() {
        if (paperStuck == true) {
            System.out.println("Error, copier is jammed");
        } else {
            if (paper > 0) {
                this.paper = this.paper - 1;
            }

            else {
                System.out.println("Insert more paper");
            }
        }

    }

    public void makeCopy(int paper) {
        if (paperStuck == true) {
            System.out.println("Error, copier is jammed");
        } else {
            if (this.paper - paper < 0) {
                System.out.println("Error, not enough paper");
            } else {
                this.paper = this.paper - paper;
            }
        }
    }

    public void makeCopyJam() {
        this.paperStuck = true;
    }

    public void fixJam() {
        this.paperStuck = false;
    }

}
