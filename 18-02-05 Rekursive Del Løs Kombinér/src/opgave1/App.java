package opgave1;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(total(list));
    }

    public static int total(List<Integer> List) {
        return total(List, 0, List.size() - 1);
    }

    private static int total(List<Integer> Bro, int start, int slut) {
        if (start == slut) {
            return Bro.get(start);
        } else {
            int middle = (start + slut) / 2;
            int total1 = total(Bro, start, middle);
            int total2 = total(Bro, middle + 1, slut);
            return total1 + total2;
        }
    }

}
