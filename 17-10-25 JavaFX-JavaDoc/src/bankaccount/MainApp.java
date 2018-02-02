package bankaccount;

public class MainApp {

    public static void main(String[] args) {
        BankAccount a = new BankAccount(1000.0);
        BankAccount b = new BankAccount(2000.0);
        BankAccount c = new BankAccount(3000.0);
        a.deposit(500.0);
        a.withdraw(250.0);
        System.out.println(a.getBalance());
        System.out.println(a.getId());
        System.out.println(b.getId());
        System.out.println(c.getId());
        System.out.println(BankAccount.getAccounts());
    }
}
