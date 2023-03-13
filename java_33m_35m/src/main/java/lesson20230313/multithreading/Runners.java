package lesson20230313.multithreading;

public class Runners {

    static volatile boolean shouldRun = false;
    static Object mutex = new Object();

    static class Runner implements Runnable{

        @Override
        public void run() {

            // busy wait approach
//            while (!shouldRun) {
//                // do nothing
////                Thread.sleep(100);
//            }
            synchronized (mutex){
                System.out.println(Thread.currentThread().getName() + " is waiting for signal!");
                try {
                    mutex.wait();
                    System.out.println(Thread.currentThread().getName() + " got signal");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Race is going to start");

        new Thread(new Runner(), "1").start();
        new Thread(new Runner(), "2").start();
        new Thread(new Runner(), "3").start();
        new Thread(new Runner(), "4").start();
        new Thread(new Runner(), "5").start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Signal!!!");
//        shouldRun = true;
        synchronized (mutex) {
            mutex.notifyAll();
            try {
                Thread.sleep(2000);
                System.out.println("Ready!");
                Thread.sleep(2000);
                System.out.println("Steady!");
                Thread.sleep(2000);
                System.out.println("Go!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }



}
