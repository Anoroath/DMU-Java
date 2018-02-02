package opgave2;

import java.util.Locale;

public class Opgave2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";
        String ord3 = ord1 + " " + ord2.toLowerCase(Locale.ROOT);

        System.out.println(ord1.toUpperCase(Locale.ROOT));
        System.out.println(ord2.toLowerCase(Locale.ROOT));

        System.out.println(ord1 + " " + ord2);
        System.out.println(ord3);
        System.out.println(ord3.length());

        String sub3 = ord3.substring(0, 7);
        System.out.println(sub3);

        String sub2 = ord2.substring(2, 7);
        System.out.println(sub2);

        String sub1 = ord3.substring(11, 23);
        System.out.println(sub1);
    }

}
