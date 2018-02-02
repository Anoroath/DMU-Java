package opgave3;

public class Opgave3 {

    public static void main(String[] args) {
        System.out.println(prod(3, 7));
        System.out.println(prodRus(3, 7));
    }

    public static int prod(int a, int b) {
        int result = 0;
        if (a == 1) {
            result = b;
        } else if (a == 0) {
            result = 0;
        } else {
            result = prod(a - 1, b) + b;
        }
        return result;
    }

    public static int prodRus(int a, int b) {
        int result = 0;
        if (a == 0) {
            result = 0;
        } else if (a % 2 != 0 && a >= 1) {
            result = prodRus(a - 1, b) + b;
        } else if (a % 2 == 0 && a >= 2) {
            result = prodRus(a / 2, 2 * b);
        }
        return result;
    }
}
