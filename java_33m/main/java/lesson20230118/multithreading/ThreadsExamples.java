package lesson20230118.multithreading;

public class ThreadsExamples {


    public static void main(String[] args) {

        // out and err streams example
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.err.println("4");
        System.err.println("5");
        System.out.println("6");

        System.out.println("Main starts");
        System.out.println(Thread.currentThread());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Additional Thread starts");
                System.out.println(Thread.currentThread());
                try {
                    System.out.println("Some operation in additional thread in progress..");
                    Thread.sleep(5000);
                    System.out.println("Some operation in additional thread in completed");
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
                System.out.println("Additional Thread ends");
            }
        };

        Thread thread = new Thread(runnable);

        System.out.println("Some operation 1 in main thread");
        thread.start();
        System.out.println("Some operation 2 in main thread");

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Some operations 3 in main thread");

        System.out.println("Main ends");

        System.out.println("------------New Example---------");

        System.out.println("Main starts");
        Thread thread1 = new Thread(new Task1(), "First");
        Thread thread2 = new Task2("Second", thread1);
        thread1.start();
        thread2.start();
        System.out.println("Operations 1 in main");


        try {
            thread1.join();
//            thread1.start();  // exception
//            thread2.join();
            System.out.println("Operations 2 in main");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Operations 3 in main");
        System.out.println("Main ends");

    }


}
