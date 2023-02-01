package lesson20230201.multithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SkatersGround {

    static Random random = new Random();
    static Semaphore semaphore = new Semaphore(5, true);

    static class Skater implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " awaits to get on the ground");
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " on the ground");
                Thread.sleep(6000 + random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " leave the ground");
            semaphore.release();
        }
    }


    public static void main(String[] args) {
        int visitorCount = 0;
        while (true){
            System.err.println("New skater wants to skate");
            new Thread(new Skater(), "Skater" + visitorCount++).start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }




}
