package lesson20230227.multithreading;

// race condition example
public class Counter {

    private static int count = 0;

    public static void main(String[] args) {

        Runnable runnable1 = () -> {
            while (true) {
                System.out.println(count++);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = () -> {
            while (true) {
                System.err.println(count++);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

    }



}
