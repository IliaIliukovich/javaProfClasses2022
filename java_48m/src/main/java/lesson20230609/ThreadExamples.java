package lesson20230609;

public class ThreadExamples {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started");
        System.out.println(Thread.currentThread());
        System.out.println(Runtime.getRuntime().availableProcessors());

        Task task = new Task();
        new Thread(task).start();
        new Thread(task).start();

        new TaskThread("TaskThread").start();

        Thread myDaemonThread = new Thread(new DaemonTask(), "MyDaemonThread");
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        System.out.println(Thread.currentThread().getName() + " finished");
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " running");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished");

        }
    }

    static class TaskThread extends Thread {

        public TaskThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " running");
            try {
                Thread.sleep(5000);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " special task from taskThread");
                    }
                });
                thread.start();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");

        }
    }

    static class DaemonTask implements Runnable {
        int count = 0;

        @Override
        public void run() {
            while (true){
                System.out.println(count++);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
