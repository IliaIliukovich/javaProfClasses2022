package lesson20230201.multithreading;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class Restaurant {

    static Random random = new Random();

    static class Chef implements Runnable {

        private SynchronousQueue<String> window;

        public Chef(SynchronousQueue<String> window) {
            this.window = window;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Cooking pizza...");
                try {
                    Thread.sleep(5000 + random.nextInt(5000));
                    System.out.println("Pizza is cooked. Take it");
                    window.put("Pizza");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiter implements Runnable {

        private SynchronousQueue<String> window;

        public Waiter(SynchronousQueue<String> window) {
            this.window = window;
        }

        @Override
        public void run() {
            while (true) {
                System.err.println("Waiting to take a dish");
                try {
                    String food = window.take();
                    System.err.println(food + " is taken");
                    Thread.sleep(5000 + random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("Pizza is delivered");
            }
        }
    }

    public static void main(String[] args) {
        SynchronousQueue<String> window = new SynchronousQueue<>();
        Chef chef = new Chef(window);
        Waiter waiter = new Waiter(window);

        new Thread(chef).start();
        new Thread(waiter).start();
    }

}
