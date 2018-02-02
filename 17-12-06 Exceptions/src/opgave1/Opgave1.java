package opgave1;

import java.util.Scanner;

public class Opgave1 {

    public static void main(String[] args) {
        int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Hvilket nr. primtal skal vises?: ");
            int n = scan.nextInt();
            System.out.println("Primtal nr. " + n + " er " + prim[n - 1] + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Det indtastede tal er ikke et heltal mellem 1 og 10.");
        }
    }

}
