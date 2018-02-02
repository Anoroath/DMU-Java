package opgave1;

public class Opgave1c {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 6;
        int b = 5;
        int c = 4;

        if (a < b && b < c) {
            System.out.print("Numbers are increasing");
        } else if (a > b && b > c) {
            System.out.print("Numbers are decreasing");
        } else {
            System.out.print("Numbers are neither increasing nor decreasing");
        }
    }

}
