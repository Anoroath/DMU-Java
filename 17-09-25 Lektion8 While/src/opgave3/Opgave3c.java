package opgave3;

import java.util.Scanner;

public class Opgave3c {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
        System.out.print("Hvilket tal ønskes tværsummen af de ulige tal? ");
        int inputTal = in.nextInt();
        int sum = 0;

        while (inputTal > 1) {
            if (!(inputTal % 2 == 0)) {
                sum = sum + inputTal % 10;
            }
            inputTal = inputTal / 10;
        }
        System.out.println(sum);
    }

}
