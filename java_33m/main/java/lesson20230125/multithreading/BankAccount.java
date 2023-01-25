package lesson20230125.multithreading;

public class BankAccount {

    private int sum;

    private final Object mutex = new Object();

    public BankAccount(int sum) {
        this.sum = sum;
    }


    public void deposit(int amount){
        synchronized (mutex) {
            sum = sum + amount;
        }
    }


    public void withdraw(int amount){
        synchronized (mutex) {
            sum = sum - amount;
        }
    }

    public int getSum() {
        synchronized (mutex) {
            return sum;
        }
    }


}
