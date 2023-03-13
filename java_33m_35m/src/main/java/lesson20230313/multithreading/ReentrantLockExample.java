package lesson20230313.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    static ReentrantLock lock = new ReentrantLock(true);

    static class Task implements Runnable{

        @Override
        public void run() {
            boolean isLocked = lock.tryLock();
            if (isLocked) {
                try {
                    System.out.println(Thread.currentThread().getName() + " does something");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    System.out.println(1 / 0);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " does something else");
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
    }


}
