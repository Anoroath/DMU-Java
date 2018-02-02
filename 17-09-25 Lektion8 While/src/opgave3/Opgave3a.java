package opgave3;

public class Opgave3a {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int i = 2;
        int n = 0;
        double sum = 0;
        while (n <= 20) {
            sum = Math.pow(i, n);
            n++;
            System.out.println(sum);
        }
    }

}
