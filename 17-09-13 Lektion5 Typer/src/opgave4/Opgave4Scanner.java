package opgave4;

import java.util.Scanner;

public class Opgave4Scanner {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the length of the rectangle ");
        int length = in.nextInt();
        System.out.print("Please enter the width of the rectangle ");
        int width = in.nextInt();

        System.out.println("Area: " + length + width);
        System.out.println("Perimeter: " + (length * 2) + (width * 2));
        System.out.println("Diagonal: " + Math.sqrt(length * length + width * width)); // Pythagores a^2 + b^2 = c^2

    }
}
