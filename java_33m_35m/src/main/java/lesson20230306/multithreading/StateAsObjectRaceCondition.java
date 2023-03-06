package lesson20230306.multithreading;

public class StateAsObjectRaceCondition {

    static class BankAccount {
        int a = 1000;
        int b = 0;
    }

    static class AccountManager {
        BankAccount account;

        public AccountManager(BankAccount account) {
            this.account = account;
        }

        public synchronized void moveMoney(int amount) {
            try {
                account.a = account.a - amount;
                Thread.sleep(500);
                account.b = account.b + amount;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized BankAccount getAccount (){
            BankAccount copy = new BankAccount();
            copy.a = account.a;
            copy.b = account.b;
            return copy;
//            return account; // возвращение account может быть небезопасно, несмотря на synchronized
        }
    }

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        AccountManager manager = new AccountManager(bankAccount);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    manager.moveMoney(10);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        while (true) {
            BankAccount account = manager.getAccount();
            try {
                Thread.sleep(50);
                System.out.println("a = " + account.a + " b = " + account.b + " total sum: " + (account.a + account.b));
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




}
