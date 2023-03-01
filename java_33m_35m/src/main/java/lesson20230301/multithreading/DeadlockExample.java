package lesson20230301.multithreading;

public class DeadlockExample {

    static Object snack = new Object();
    static Object drink = new Object();

    static class Cat implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (snack) {
                    System.out.println(Thread.currentThread().getName() + " started eating");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (drink) {
                        System.out.println(Thread.currentThread().getName() + " started drinking");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " finished drinking");
                    }
                    System.out.println(Thread.currentThread().getName() + " finished eating");
                }
//                try {
//                    System.out.println(Thread.currentThread().getName() + " is resting");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }
    }

    static class Dog implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (drink) {
                    System.out.println(Thread.currentThread().getName() + " started drinking");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (snack) {
                        System.out.println(Thread.currentThread().getName() + " started eating");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " finished eating");
                    }
                    System.out.println(Thread.currentThread().getName() + " finished drinking");
                }

//                try {
//                    System.out.println(Thread.currentThread().getName() + " is resting");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new Cat(), "Tom").start();
//        new Thread(new Cat(), "Nike").start();
        new Thread(new Dog(), "Nike").start();

    }



}
