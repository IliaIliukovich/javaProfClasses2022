package lesson20230315.multithreading;

import java.util.concurrent.SynchronousQueue;

public class SyncQueueCafe {

    static SynchronousQueue<String> order = new SynchronousQueue<>(true);
    static SynchronousQueue<String> food = new SynchronousQueue<>(true);

    static class Visitor implements Runnable{

        String wishEat;

        public Visitor(String wishEat) {
            this.wishEat = wishEat;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": coming in");
            try {
                System.out.println(Thread.currentThread().getName() + ": giving order");
                order.put(wishEat);
                System.out.println(Thread.currentThread().getName() + ": waiting for lunch");
                String foodForVisitor = food.take();
                System.out.println(Thread.currentThread().getName() + ": eats: " + foodForVisitor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class Chef implements Runnable{

        @Override
        public void run() {
            System.out.println("Waiting for a visitor");
            while (true) {
                try {
                    String orderToCook = order.take();
                    System.out.println("Received order: " + orderToCook);
                    System.out.println("Cooking lunch");
                    Thread.sleep(5000);
                    System.out.println("Lunch cooked");
                    food.put(orderToCook);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread threadChef = new Thread(new Chef());
        threadChef.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Visitor("pizza"), "Vasua").start();
        new Thread(new Visitor("pasta"), "Petua").start();
        new Thread(new Visitor("cheessecake"), "Masha").start();
    }




}
