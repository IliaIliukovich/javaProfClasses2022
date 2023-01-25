package lesson20230125.multithreading;

public class StateAsObjectRaceCondition {

    static class BankAccount {

        int accountA = 1000;
        int accountB = 0;

    }

    static class ManageAccount {

        BankAccount account;

        public ManageAccount(BankAccount account) {
            this.account = account;
        }

        public synchronized void moveMoney(int sum) {
            try {
                account.accountA -= sum;
                Thread.sleep(20);
                account.accountB += sum;
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized BankAccount getAccount() {
//            return account;  // возвращение account может быть небезопасно, несмотря на synchronized
            BankAccount newAcc = new BankAccount();
            newAcc.accountA = account.accountA;
            newAcc.accountB = account.accountB;
            return newAcc;
        }


    }

    public static void main(String[] args) {

        ManageAccount manager = new ManageAccount(new BankAccount());

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                manager.moveMoney(40);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

//        BankAccount account = manager.getAccount();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                BankAccount account = manager.getAccount();
                System.out.println("a = " + account.accountA + " b = " + account.accountB +
                        " total = " + (account.accountA + account.accountB));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }

}
