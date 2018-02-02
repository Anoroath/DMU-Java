package bankaccount;

public class BankAccount {
    private double balance;
    private int id;
    private static int accounts;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        BankAccount.accounts++;
        this.id = BankAccount.accounts;
    }

    /**
     * Changes total balance according to deposited amount.
     *
     * @param amount
     *            & balance. Precondition: amount > 0.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Changes total balance according to withdrawn amount.
     *
     * @param amount
     *            & balance. Precondition: amount > 0, balance > 0.
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Returns the total balance of the bank account.
     *
     * @return balance.
     */
    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public static int getAccounts() {
        return BankAccount.accounts;
    }

}
