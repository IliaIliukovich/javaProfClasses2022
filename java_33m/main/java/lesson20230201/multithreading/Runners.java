package lesson20230201.multithreading;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Runners {

    static CountDownLatch latch = new CountDownLatch(3);
    static Random random = new Random();
    static CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("The winner is.."));


    static class Runner implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " preparing to run");
                latch.await();
                System.out.println(Thread.currentThread().getName() + " runs");
                Thread.sleep(5000 + random.nextInt(15000));
                System.out.println(Thread.currentThread().getName() + " finished");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " goes home");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        new Thread(new Runner(), "Runner1").start();
        new Thread(new Runner(), "Runner2").start();
        new Thread(new Runner(), "Runner3").start();
        new Thread(new Runner(), "Runner4").start();
        new Thread(new Runner(), "Runner5").start();
        new Thread(new Runner(), "Runner6").start();
        new Thread(new Runner(), "Runner7").start();
        new Thread(new Runner(), "Runner8").start();
        new Thread(new Runner(), "Runner9").start();

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

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ends");
    }


}
