package konto;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Konto Anders = new Konto(1, 2000, "Opsparing");
        Anders.indsætBeløb(100);
        Anders.indsætBeløb(542);
        System.out.print(Anders.getSaldo());
    }

}
