package lesson20230315.multithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SkatersGround {

    private static Semaphore semaphore = new Semaphore(5, true);
    private static Random random = new Random();

    static class Skater implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " coming to the skaters ground");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " on the ground");
                Thread.sleep(8000 + random.nextInt(8000));
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " leaving the ground");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            new Thread(new Skater()).start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
