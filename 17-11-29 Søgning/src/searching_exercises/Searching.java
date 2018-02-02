package searching_exercises;

public class Searching {

    public static boolean findUneven(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            if (k % 2 != 0) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            return true;
        } else {
            return false;
        }
    }

    public static int findFirst(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            if (k >= 10 && k <= 15) {
                found = true;
                return k;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static boolean findSame(int[] tabel) {
        boolean found = false;
        int i = 0;
        int j = 0;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            if (k == j) {
                found = true;
                return true;
            } else {
                i++;
                j = k;
            }
        }
        return false;
    }
}
