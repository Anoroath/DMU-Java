package opgave1;

public class Opgave2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int i = 1;
        int sum = 0;

        while (i <= 100) {
            sum = i * i + sum;
            i++;
        }
        System.out.println(sum);
    }

}
