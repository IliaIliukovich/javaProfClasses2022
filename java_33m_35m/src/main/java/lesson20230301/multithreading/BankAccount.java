package lesson20230301.multithreading;

public class BankAccount {

    private int sum;

    public synchronized void deposit(int amount) {
        sum = sum + amount;
    }

    public synchronized void withdraw(int amount) {
        sum = sum - amount;
    }

    public synchronized int getSum(int amount) {
        return sum;
    }


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100);
        bankAccount.withdraw(100);

        synchronized (bankAccount) {
            // operations with bankAccount
        }
    }
}
