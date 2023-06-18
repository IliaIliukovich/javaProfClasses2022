package lesson20230616;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int account1 = 1000;
    private int account2 = 0;

    public synchronized void moveMoney(int amount){
        account1 = account1 - amount;
        // a1 = 500
        // a2 = 0
        account2 = account2 + amount;
    }

    public synchronized int getAccount1() {
            return account1;
    }

    public synchronized int getAccount2() {
        return account2;
    }


    public static void main(String[] args) {

//        String mutex1 = new String("LOCK");
//        String mutex2 = new String("LOCK");
//        String mutex3 = "LOCK";
//        String mutex4 = "LOCK";
//
//        System.out.println(mutex1 == mutex2);
//        System.out.println(mutex3 == mutex4);

        BankAccount bankAccount = new BankAccount();

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (bankAccount) {
                bankAccount.moveMoney(500);
                bankAccount.moveMoney(500);
            }
        }
        ).start();

        new Thread(() -> {
            synchronized (bankAccount) {
                System.out.println(bankAccount.getAccount1());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(bankAccount.getAccount2());
            }
        }
        ).start();
    }

}
