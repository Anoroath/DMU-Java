package opgave1;

import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {
        ArrayList<Kunde> l1 = new ArrayList<>();
        l1.add(new Kunde("A", "A", 1));
        l1.add(new Kunde("C", "C", 1));
        l1.add(new Kunde("G", "G", 1));

        ArrayList<Kunde> l2 = new ArrayList<>();
        l2.add(new Kunde("B", "B", 1));
        l2.add(new Kunde("B", "C", 1));
        l2.add(new Kunde("D", "D", 1));
        l2.add(new Kunde("D", "G", 1));
        l2.add(new Kunde("E", "E", 1));
        l2.add(new Kunde("E", "G", 1));
        l2.add(new Kunde("F", "F", 1));
        l2.add(new Kunde("F", "G", 1));
        System.out.println(fletAlleKunder(l1, l2));
    }

    public static ArrayList<Kunde> fletAlleKunder(ArrayList<Kunde> l1, ArrayList<Kunde> l2) {
        ArrayList<Kunde> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo((l2.get(i2))) <= 0) {
                result.add(l1.get(i1));
                i1++;
            } else {
                result.add(l2.get(i2));
                i2++;
            }
        }
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }
        return result;
    }
}
