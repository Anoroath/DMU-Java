package filer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PrintWriterTal {

    public static void main(String[] args) {
        try {
            String fileName = "src/opgave5/tal2.txt";
            try (PrintWriter printWriter = new PrintWriter(fileName)) {

                // Indlæs antal tal i filen
                try (Scanner scan = new Scanner(System.in)) {
                    System.out.print("Antal tal der skal skrives i filen: ");
                    int antal = scan.nextInt();

                    // Skab tilfældige tal generator Random
                    Random rnd = new Random();

                    // Generer og skriv de tilfældige tal
                    for (int n = 1; n <= antal; n++) {
                        int tal = rnd.nextInt(10000);
                        printWriter.println(tal);
                    }
                }
            }
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
