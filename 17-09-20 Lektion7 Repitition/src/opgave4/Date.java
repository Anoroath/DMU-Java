package opgave4;

public class Date {
    private int month;
    private int day;
    private String season;

    public Date(int inputMonth, int inputDay) {
        this.month = inputMonth;
        this.day = inputDay;
    }

    public void getSeason() {
        if (this.month == 1 || this.month == 2 || this.month == 3) {
            this.season = "Winter";
        } else if (this.month == 4 || this.month == 5 || this.month == 6) {
            this.season = "Spring";
        } else if (this.month == 7 || this.month == 8 || this.month == 9) {
            this.season = "Summer";
        } else if (this.month == 10 || this.month == 11 || this.month == 12) {
            this.season = "Fall";
        }

        if (this.month % 3 == 0 && this.day >= 21) {
            if (this.season == "Winter") {
                this.season = "Spring";
            } else if (this.season == "Spring") {
                this.season = "Summer";
            } else if (this.season == "Summer") {
                this.season = "Fall";
            } else if (this.season == "Fall") {
                this.season = "Winter";
            }
        }
        System.out.println(this.season);

    }

}
