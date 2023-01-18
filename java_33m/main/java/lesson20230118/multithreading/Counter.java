package lesson20230118.multithreading;

public class Counter {

    // Race condition example
    static int count = 0;

    static Object mutex = new Object();

    static class CounterTask implements Runnable {

        @Override
        public void run() {
            while (true) {
//                    count++; --------->       int tmp = count;
////                                            tmp = tmp + 1;
////                                            count = tmp;

//                synchronized (mutex) {
                    extracted();
//                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        synchronized private void extracted() {
//            synchronized (this) {
                count++;
                System.out.println(count);
//            }
        }
    }

    public static void main(String[] args) {

        CounterTask r = new CounterTask();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);

        thread1.start();
        thread2.start();

    }




}
