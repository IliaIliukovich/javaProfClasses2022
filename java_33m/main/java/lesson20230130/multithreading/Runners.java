package lesson20230130.multithreading;

public class Runners {

    static volatile boolean shouldRun = false;
    static Object trigger = new Object();

    static class Runner implements Runnable {

        @Override
        public void run() {

            // busy wait решение с volatile флагом shouldRun - возможно, но ресурсозатратно
//            while (!shouldRun) {
//                // do nothing
//            }

            synchronized (trigger){
//                boolean shouldWait = true; // условие, чтобы бегун не побежал при вызове t.interrupt()
//                while (shouldWait) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " waits");
                        trigger.wait();
//                        shouldWait = false;
                        System.out.println(Thread.currentThread().getName() + " awaken");
                        Thread.sleep(3000);
                    } catch(InterruptedException e){
                        System.out.println(Thread.currentThread().getName() + " interrupted");
                    }
//                }
            }

            while (true) {
                System.out.println(Thread.currentThread().getName() + " runs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runner(), "1");
        Thread t2 = new Thread(new Runner(), "2");
        Thread t3 = new Thread(new Runner(), "3");
        Thread t4 = new Thread(new Runner(), "4");
        Thread t5 = new Thread(new Runner(), "5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        System.out.println("Runners created");
//        t1.interrupt();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t1.interrupt();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runners should run");
//        shouldRun = true;
        synchronized (trigger) {
            trigger.notifyAll();
            try {
                Thread.sleep(1000);
                System.out.println("Ready!");
                Thread.sleep(1000);
                System.out.println("Steady!");
                Thread.sleep(1000);
                System.out.println("Go!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}
