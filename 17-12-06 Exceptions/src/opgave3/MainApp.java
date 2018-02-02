package opgave3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        try (FileInputStream filein = new FileInputStream("src/opgave3/file.txt")) {
            try (Scanner scan = new Scanner(filein)) {
                ArrayList<Integer> tal = new ArrayList<>();
                while (scan.hasNext()) {
                    tal.add(Integer.parseInt(scan.nextLine()));
                }
                for (int i = tal.size() - 1; i >= 0; i--) {
                    System.out.println(tal.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}