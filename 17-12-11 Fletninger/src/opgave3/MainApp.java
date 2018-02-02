package opgave3;

import java.util.ArrayList;

import opgave1.Kunde;

public class MainApp {

    public static void main(String[] args) {
        ArrayList<Kunde> l1 = new ArrayList<>();
        l1.add(new Kunde("A", "A", 1));
        l1.add(new Kunde("C", "C", 1));
        l1.add(new Kunde("F", "F", 1));
        l1.add(new Kunde("G", "G", 1));

        Kunde[] l2 = new Kunde[8];
        l2[0] = new Kunde("B", "B", 1);
        l2[1] = new Kunde("C", "C", 1);
        l2[2] = new Kunde("D", "D", 1);
        l2[3] = new Kunde("D", "G", 1);
        l2[4] = new Kunde("E", "E", 1);
        l2[5] = new Kunde("E", "G", 1);
        l2[6] = new Kunde("F", "F", 1);
        l2[7] = new Kunde("F", "G", 1);
        System.out.println(godeKunder(l1, l2));
    }

    public static ArrayList<Kunde> godeKunder(ArrayList<Kunde> l1, Kunde[] l2) {
        ArrayList<Kunde> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) < 0) {
                result.add(l1.get(i1));
                i1++;
            } else if (l1.get(i1).compareTo(l2[i2]) > 0) {
                i2++;
            } else {
                i1++;
                i2++;
            }
        }
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        return result;
    }
}
