package arrayList;

import java.util.ArrayList;

public class ArrayListApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ArrayList<String> names = new ArrayList<>();
        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Børge");
        names.add("Bent");
        System.out.println(names.size());
        names.add(2, "Jane");
        System.out.println(names);
        names.remove(1);
        names.add(0, "Pia");
        names.add("Ib");
        System.out.println(names.size());
        names.set(2, "Hansi");
        System.out.println(names.size());
        System.out.println(names);
        
    }

}
