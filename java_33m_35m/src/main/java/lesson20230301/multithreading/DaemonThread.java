package lesson20230301.multithreading;

public class DaemonThread {

    public static void main(String[] args) {

        Runnable runner = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " runs");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        Thread thread = new Thread(runner, "Runner");
        thread.setDaemon(true);
        thread.start();

//        System.out.println(thread.isInterrupted());
//        thread.interrupt();
//        System.out.println(thread.isInterrupted());

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }



}
