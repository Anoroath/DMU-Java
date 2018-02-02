package application.model;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Konference k = new Konference("Bla", "Jorden", LocalDate.of(2017, 11, 15), LocalDate.of(2017, 11, 17), 1500.0);
        Hotel h = new Hotel("Hvid svane", 1050, 1250);

        Deltager d = new Deltager("Finn", "Madsen", "Århus", "112", "Danmark");

        Tilmeldning t = new Tilmeldning(LocalDate.of(2017, 11, 15), LocalDate.of(2017, 11, 17), true, d, k);
        t.createLedsager("Mie", "Sommer");
        t.setHotel(h);
        t.addTillæg(h.createTillæg("Wifi", 50));
        Udflugt u = new Udflugt("Egeskov", " ", LocalDate.of(2017, 11, 16), 75, false);
        Udflugt u2 = new Udflugt("Odense", " ", LocalDate.of(2017, 11, 16), 125, true);

        t.addUdflugt(u);
        t.addUdflugt(u2);

        System.out.println(t.samletPris());
        System.out.println(t.getTillæg());
    }

}
