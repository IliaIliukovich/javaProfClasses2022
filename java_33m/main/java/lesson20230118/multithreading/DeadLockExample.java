package lesson20230118.multithreading;

public class DeadLockExample {

    static Object o1 = new Object();
    static Object o2 = new Object();

    static class Task1 implements Runnable{
        @Override
        public void run() {
            synchronized (o1) {
                System.out.println("Task1 works with o1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (o2) {
                    System.out.println("Task1 works with o2");

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            System.out.println("Task1 finished");
        }
    }

    static class Task2 implements Runnable{
        @Override
        public void run() {

            synchronized (o2) {
                System.out.println("Task2 works with o2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (o1) {
                    System.out.println("Task2 works with o1");

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            System.out.println("Task 2 finished");

        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());
        thread1.start();
        thread2.start();

    }



}
