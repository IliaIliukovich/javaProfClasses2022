package lesson20230306.multithreading;

public class BankAccountWithInnerMutex {

    private int sum;

    private Object mutex = new Object();

    public void deposit(int amount) {
        synchronized (mutex) {
            sum = sum + amount;
        }
    }

    public void withdraw(int amount) {
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
