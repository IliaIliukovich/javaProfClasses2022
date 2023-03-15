package lesson20230315.multithreading;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Runners {

    static CountDownLatch latch = new CountDownLatch(3);
    static CyclicBarrier barrier = new CyclicBarrier(3,
            () -> System.out.println(Thread.currentThread().getName() + " The winner is ..."));
    static Random random = new Random();

    static class Runner implements Runnable {
        @Override
        public void run() {

        System.out.println(Thread.currentThread().getName() + ": Preparing to run");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Thread.currentThread().getName() + ": Running");
            Thread.sleep(5000 + random.nextInt(15000));
            System.out.println(Thread.currentThread().getName() + ": Reached finish");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + ": Going home");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
//                barrier.reset();
            }
        }
    }


    public static void main(String[] args) {

        Thread thread = new Thread(new Runner(), "Runner1");
        thread.start();
        new Thread(new Runner(), "Runner2").start();
        new Thread(new Runner(), "Runner3").start();
        new Thread(new Runner(), "Runner4").start();
        new Thread(new Runner(), "Runner5").start();
        new Thread(new Runner(), "Runner6").start();
        new Thread(new Runner(), "Runner7").start();
        new Thread(new Runner(), "Runner8").start();
        new Thread(new Runner(), "Runner9").start();

        System.out.println("This is the race! Get ready");

        try {
            Thread.sleep(3000);
            System.out.println("Ready!");
            latch.countDown();
            Thread.sleep(3000);
            System.out.println("Steady!");
            latch.countDown();
            Thread.sleep(3000);
            System.out.println("Go!");
            latch.countDown();


//            Thread.sleep(10000);
//            thread.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
