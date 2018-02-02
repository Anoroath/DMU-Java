package opgave2;

public class Opgave2 {

    public static void main(String[] args) {
        System.out.println(power(3, 5));
        System.out.println(power2(3, 5));
    }

    public static int power(int n, int p) {
        int result = 0;
        if (p == 0) {
            result = 1;
        } else {
            result = power(n, p - 1) * n;
        }

        return result;
    }

    public static int power2(int n, int p) {
        int result = 0;
        if (p == 0) {
            result = 1;

        } else if (p % 2 != 0) {
            result = power2(n, p - 1) * n;

        } else {
            result = power2(n * n, p / 2);
        }
        return result;
    }

}