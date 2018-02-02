package opgave2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        try (FileInputStream filein = new FileInputStream("src/opgave2/file.txt")) {
            try (Scanner scan = new Scanner(filein)) {
                while (scan.hasNext()) {
                    System.out.println(Integer.parseInt(scan.nextLine()) * 2);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
