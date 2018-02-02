package opgave5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FilUtil {

    public static int max(String fileName) {
        int max = 0;
        try (FileInputStream filein = new FileInputStream(fileName)) {
            try (Scanner scan = new Scanner(filein)) {
                while (scan.hasNext()) {
                    int next = scan.nextInt();
                    if (next > max) {
                        max = next;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return max;
    }

    public static int min(String fileName) {
        int min = max(fileName);
        try (FileInputStream filein = new FileInputStream(fileName)) {
            try (Scanner scan = new Scanner(filein)) {
                while (scan.hasNext()) {
                    int next = scan.nextInt();
                    if (next < min) {
                        min = next;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return min;
    }

    public static double gennemsnit(String fileName) {
        int sum = 0;
        double antal = 0.0;
        try (FileInputStream filein = new FileInputStream(fileName)) {
            try (Scanner scan = new Scanner(filein)) {
                while (scan.hasNext()) {
                    int next = scan.nextInt();
                    sum += next;
                    antal++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sum / antal;
    }
}
