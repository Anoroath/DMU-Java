package opgave16;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showInputDialog("My name is Hal, what would you like me to do?");
        System.out.print("I´m sorry, ");
        System.out.print(name);
        System.out.print(". I´m afriad I can´t do that.");
    }

}
