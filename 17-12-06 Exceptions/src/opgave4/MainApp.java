package opgave4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        try {
            String fileName = "src/opgave4/tal1.txt";
            try (PrintWriter printWriter = new PrintWriter(fileName)) {

                try (Scanner scan = new Scanner(System.in)) {
                    System.out.print("Skriv de tal der ønskes i filen. Afslut med -1: ");
                    int next;
                    while (scan.hasNext()) {
                        next = scan.nextInt();

                        if (next != -1) {
                            if (next > 0) {
                                printWriter.println(next);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
