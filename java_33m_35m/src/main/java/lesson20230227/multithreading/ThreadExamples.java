package lesson20230227.multithreading;

public class ThreadExamples {


    static int count = 0;

    public static void main(String[] args) {

        System.out.println("Main starts");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " started");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    count = i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " finished");
            }
        };

        Runnable runnable2 = () -> System.out.println("New operations in " + Thread.currentThread());


        Thread thread1 = new Thread(runnable1, "New thread");
        Thread thread2 = new Thread(runnable2, "New thread2");
        System.out.println("Threads created");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        thread1.start();
        thread2.start();
        System.out.println("Threads started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count = " + count);
        System.out.println("Main ends");



//        // Custom thread example
//        Thread customThread = new CustomThread();
//        customThread.start();
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//
//        }
//
//        customThread.interrupt();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//
//        }
//        customThread.interrupt();
//
//        customThread.start();  // exception - cannot start thread again

    }


}
