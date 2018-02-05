package opgave3;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ArrayList<Integer> benis = new ArrayList<>(Arrays.asList(8, 56, 45, 34, 15, 12, 34, 44));
        System.out.println(mergeSort(benis));
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        return mergeSort(list, 0, list.size() - 1);
    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> list, int start, int slut) {
        if (start < slut) {
            int m = (start + slut) / 2;
            mergeSort(list, start, m);
            mergeSort(list, m + 1, slut);
            merge(list, start, m, slut);
        }
        return list;
    }

    private static void merge(ArrayList<Integer> list, int start, int middle, int slut) {
        int i1 = start;
        int i2 = middle + 1;
        ArrayList<Integer> result = new ArrayList<>();

        while (i1 < middle + 1 && i2 < slut + 1) {
            if (list.get(i1).compareTo(list.get(i2)) <= 0) {
                result.add(list.get(i1));
                i1++;
            } else {
                result.add(list.get(i2));
            }
        }

        while (i1 < middle + 1) {
            result.add(list.get(i1));
            i1++;
        }

        while (i2 < slut) {
            result.add(list.get(i2));
            i2++;
        }

        for (int i = 0; i < result.size(); i++) {
            list.set(start + i, result.get(i));
        }
    }
}
