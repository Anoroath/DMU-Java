package opgave4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        System.out.println(linFileSearchNumber("src/opgave4/talfil.txt", 5885));
    }

    public static boolean linFileSearchNumber(String fileName, int target) {
        try (FileInputStream filein = new FileInputStream(fileName)) {
            try (Scanner scan = new Scanner(filein)) {
                while (scan.hasNext()) {
                    int next = scan.nextInt();
                    if (next == target) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
