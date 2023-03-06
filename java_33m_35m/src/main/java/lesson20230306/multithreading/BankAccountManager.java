package lesson20230306.multithreading;

public class BankAccountManager {

    public static void main(String[] args) {

        String s1 = "LOCK";
        String s2 = new String("LOCK");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

//        BankAccount bankAccount = new BankAccount();
        BankAccountWithInnerMutex bankAccount = new BankAccountWithInnerMutex();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    bankAccount.deposit(100);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    bankAccount.withdraw(100);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


            synchronized (bankAccount) {
                while (true) {
                System.out.println(bankAccount.getSum());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
