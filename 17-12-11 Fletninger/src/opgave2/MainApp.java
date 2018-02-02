package opgave2;

import java.util.ArrayList;
import java.util.Arrays;

import opgave1.Kunde;

public class MainApp {

    public static void main(String[] args) {
        int[] l1 = { 2, 4, 6, 8, 10, 12, 14 };
        int[] l2 = { 1, 2, 4, 5, 6, 9, 12, 17 };
        System.out.println(Arrays.toString(fællesTal(l1, l2)));
    }

    public static int[] fællesTal(int[] l1, int[] l2) {
        int[] temp = new int[l1.length + l2.length];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            } else if (l1[i1] > l2[i2]) {
                i2++;
            } else {
                temp[j] = l1[i1];
                j++;
                i1++;
                i2++;
            }
        }
        int[] result = new int[j];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}
