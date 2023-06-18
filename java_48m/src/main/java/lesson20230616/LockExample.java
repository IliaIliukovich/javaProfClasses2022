package lesson20230616;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    static ReentrantLock lock = new ReentrantLock(true);

    static int counter = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    counter++;
                    Thread.sleep(1000);
                    System.out.println(counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                System.out.println(Thread.currentThread().getName() + " got access to lock");
                Thread.sleep(5000);
                System.out.println(1 / 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released lock");
                }
            }
        }).start();


    }

}
