package lesson20230616;

public class Runners {
        static Object command = new Object();

    static class Runner implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " preparing to run");
            synchronized (command) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting for a command...");
                    command.wait();
                    System.out.println(Thread.currentThread().getName() + " awaken");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (true) {
                System.out.println(Thread.currentThread().getName() + " running");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread runner1 = new Thread(new Runner(), "Runner1");
        Thread runner2 = new Thread(new Runner(), "Runner2");
        Thread runner3 = new Thread(new Runner(), "Runner3");
        runner1.start();
        runner2.start();
        runner3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (command) {
            System.out.println("Ready!");
            System.out.println("Steady!");
            System.out.println("Go!");
            command.notifyAll();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " out of sync block");



    }



}
