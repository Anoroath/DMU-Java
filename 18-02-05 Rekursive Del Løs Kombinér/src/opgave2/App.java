package opgave2;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(Nul(list));
    }

    public static int Nul(List<Integer> List) {
        return Nul(List, 0, List.size() - 1);
    }

    private static int Nul(List<Integer> Bro, int start, int slut) {
        if (start == slut) {
            return Bro.get(start) == 0 ? 1 : 0;
        } else {
            int middle = (start + slut) / 2;
            int Hul = Nul(Bro, start, middle);
            int Bagdøren = Nul(Bro, middle + 1, slut);
            return Hul + Bagdøren;
        }
    }

}