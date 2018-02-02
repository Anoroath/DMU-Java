package opgave3;

import java.util.Scanner;

public class Opgave3b {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
        System.out.print("What is a? ");
        int a = in.nextInt();
        System.out.print("What is b? ");
        int b = in.nextInt();

        int sum = 0;
        while (a <= b) {
            if (!(a % 2 == 0)) {
                sum = sum + a;
            }
            a++;
        }
        System.out.println(sum);
    }

}
