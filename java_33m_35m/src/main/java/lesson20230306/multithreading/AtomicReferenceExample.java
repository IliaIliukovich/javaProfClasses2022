package lesson20230306.multithreading;

import lesson20230301.multithreading.BankAccount;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {


    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000);
        AtomicReference<BankAccount> reference = new AtomicReference<>(bankAccount);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(reference.get().getSum());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reference.set(new BankAccount());

    }




}
