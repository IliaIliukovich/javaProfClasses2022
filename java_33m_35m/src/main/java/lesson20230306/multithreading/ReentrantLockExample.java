package lesson20230306.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    static int count;

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    increment();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    increment();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private static void increment() {
        lock.lock();
            count++;
            System.out.println(count);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extracted();
        lock.unlock();
    }

    private static void extracted() {
        lock.lock();
        // operations
        lock.unlock();
    }


}
