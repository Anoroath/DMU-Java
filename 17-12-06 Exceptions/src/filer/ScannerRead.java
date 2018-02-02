package filer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerRead {

	public static void main(String[] args) {
		try (FileInputStream filein = new FileInputStream("tal.txt")) {
			try (Scanner scan = new Scanner(filein)) {
    			while (scan.hasNext()) {
    				System.out.println(scan.nextLine());
    			}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
