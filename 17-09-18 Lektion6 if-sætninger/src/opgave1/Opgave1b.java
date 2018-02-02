package opgave1;

public class Opgave1b {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int digit = -12;

        if (digit < 0) {
            digit = digit * (-1);
        }
        if (digit >= 1000000000) {
            System.out.print("Number contains 10 digits");
        } else if (digit >= 100000000) {
            System.out.print("Number contains 9 digits");
        } else if (digit >= 10000000) {
            System.out.print("Number contains 8 digits");
        } else if (digit >= 1000000) {
            System.out.print("Number contains 7 digits");
        } else if (digit >= 100000) {
            System.out.print("Number contains 6 digits");
        } else if (digit >= 10000) {
            System.out.print("Number contains 5 digits");
        } else if (digit >= 1000) {
            System.out.print("Number contains 4 digits");
        } else if (digit >= 100) {
            System.out.print("Number contains 3 digits");
        } else if (digit >= 10) {
            System.out.print("Number contains 2 digits");
        } else if (digit >= 0) {
            System.out.print("Number contains 1 digits");
        }

    }

}
