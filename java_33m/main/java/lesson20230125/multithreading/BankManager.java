package lesson20230125.multithreading;

public class BankManager {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(1000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bankAccount.deposit(20);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bankAccount.withdraw(20);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        // если бы в BankAccount методы deposit или withdraw были synchronized, данный кусок кода привел бы к
        // блокировке потоков t1 и t2
        synchronized (bankAccount) {
            while (true) {
                System.out.println(bankAccount.getSum());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
