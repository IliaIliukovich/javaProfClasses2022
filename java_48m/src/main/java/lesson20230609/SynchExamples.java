package lesson20230609;

import java.util.Vector;

public class SynchExamples {

    public static void main(String[] args) {

        Task task = new Task();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        synchronized (task) {
            System.out.println(Thread.currentThread().getName() + " in sync section");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Vector<String> vector1 = new Vector<>();
        vector1.add("One");
        new Thread(() -> {
            vector1.get(0);
            return;
        }).start();

//        Vector<String> vector2 = new Vector<>();
//        vector2.add("One");
    }


    static class Task implements Runnable {
        @Override
        public synchronized void run() {
            System.out.println(Thread.currentThread().getName() + " doing task");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
