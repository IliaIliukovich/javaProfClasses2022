package lesson20230315.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class RestaurantExtendedModel {

    // лимит на количество посетителей
    static Semaphore semaphore = new Semaphore(5, true);
    // очередь всех столов, обслуживаемых официантом
    static BlockingQueue<Exchanger<Tray>> restaurantTables = new LinkedBlockingQueue<>();
    static Random random = new Random();

    private static class Visitor implements Runnable {
        // поднос с меню/едой
        private Tray tray = new Tray();
        // стол постителя
        private Exchanger<Tray> visitorTable = new Exchanger<>();

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " comes to the restaurant");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is in and makes order");
                restaurantTables.put(visitorTable);
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " waits for lunch");
                // обмен пустого подноса на поднос с едой
                tray = visitorTable.exchange(tray);
                System.out.println(Thread.currentThread().getName() + " eats " + tray.dishes);
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " has eaten and leaves the " +
                        "restaurant");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Chef implements Runnable {
        // блюдо
        private Dish dish;
        // очередь готовых блюд
        private BlockingQueue<Dish> plates;

        public Chef(Dish dish, BlockingQueue<Dish> plates) {
            this.dish = dish;
            this.plates = plates;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Cooking " + dish);
                try {
                    Thread.sleep(20000 + random.nextInt(10000));
                    System.out.println(dish + " is cooked. Take it");
                    plates.put(dish);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Waiter implements Runnable{
        // очереди готовых блюд
        private BlockingQueue<Dish> plates1;
        private BlockingQueue<Dish> plates2;
        private BlockingQueue<Dish> plates3;
        // поднос с меню/едой
        private Tray tray = new Tray();

        public Waiter(BlockingQueue<Dish> plates1, BlockingQueue<Dish> plates2, BlockingQueue<Dish> plates3) {
            this.plates1 = plates1;
            this.plates2 = plates2;
            this.plates3 = plates3;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Waiter waiting to take a dish");
                try {
                    tray.dishes.add(plates1.take());
                    tray.dishes.add(plates2.take());
                    tray.dishes.add(plates3.take());
                    System.out.println("Waiter filled the tray");
                    // обмен подноса с едой на пустой поднос в порядке очереди посетителей
                    tray = restaurantTables.take().exchange(tray);
                    System.out.println("Waiter brought the tray to a visitor");
                    Thread.sleep(3000);
                    System.out.println("Waiter brought back tray " +  tray);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Dish> mainCoursePlates = new ArrayBlockingQueue<>(5);
        BlockingQueue<Dish> saladPlates = new ArrayBlockingQueue<>(5);
        BlockingQueue<Dish> soupPlates = new ArrayBlockingQueue<>(5);

        new Thread(new Chef(Dish.MAIN_COURSE, mainCoursePlates), "Chef1").start();
        new Thread(new Chef(Dish.SALAD, saladPlates), "Chef2").start();
        new Thread(new Chef(Dish.SOUP, soupPlates), "Chef3").start();
        new Thread(new Waiter(mainCoursePlates, saladPlates, soupPlates), "Waiter1").start();

        int i = 1;
        while (true) {
            new Thread(new Visitor(), "Visitor" + i++).start();
            try {
                Thread.sleep(random.nextInt(25000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private enum Dish {
        SOUP, SALAD, MAIN_COURSE
    }

    private static class Tray {
        List<Dish> dishes = new ArrayList<>(3);

        @Override
        public String toString() {
            return "Tray{" + "dishes=" + dishes + '}';
        }
    }

}
