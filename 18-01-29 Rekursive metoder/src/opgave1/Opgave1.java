package opgave1;

public class Opgave1 {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else {
            result = factorial(n - 1) * n;
        }
        return result;
    }
}
