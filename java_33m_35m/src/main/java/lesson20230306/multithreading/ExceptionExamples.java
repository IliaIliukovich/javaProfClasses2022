package lesson20230306.multithreading;

public class ExceptionExamples {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Default logic for exceptions. Thread: " + t.getName() + ". Message: " + e.getMessage());
            }
        });


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    System.out.println(Thread.currentThread().getName() + " works");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    throw new RuntimeException("Something wrong");
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                    throw new RuntimeException("Something wrong");
            }
        };

        Thread thread1 = new Thread(runnable, "New Thread");
        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("Special logic 1 for exceptions. Thread: " + t.getName() + ". Message: " + e.getMessage());
            }
        });
        thread1.start();

        new Thread(runnable2).start();

        System.out.println(Thread.currentThread().getName() + " works");
        System.out.println(1 / 0);

    }



}
