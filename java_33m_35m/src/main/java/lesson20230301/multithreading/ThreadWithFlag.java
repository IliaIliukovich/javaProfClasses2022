package lesson20230301.multithreading;

public class ThreadWithFlag {

    static long counter = 0;
    static volatile boolean flag = true;

    static class Task implements Runnable{

        @Override
        public void run() {
//            while (!Thread.interrupted()) {
            while (flag) {
                counter++;
                if (counter % 100_000 == 0) {
                    System.out.println(counter);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        thread.interrupt();
        flag = false;

        // 2021600000 thread.interrupt()
        // 2307300000 volatile
        // 2734400000 without volatile

    }




}
