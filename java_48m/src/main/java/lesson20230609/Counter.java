package lesson20230609;

public class Counter {

    static Integer count = 0;

    static Object mutex = new Object();


    public static void main(String[] args) throws InterruptedException {

        new Thread(new Task1()).start();
        new Thread(new Task2()).start();

        while (true) {
            System.out.println(count);
            Thread.sleep(1000);
        }
    }

    static class Task1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                increment();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized static void increment() {
//            synchronized (mutex) {
//            synchronized (Counter.class) {
        int tmp = count;
        tmp++;
        count = tmp;
//            }
    }

    static class Task2 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                synchronized (mutex) {
                synchronized (Counter.class) {
                    count++;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
