package lesson20230123.multithreading;

public class ThreadsAndExceptions {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Some general exception " + t.getName());
            }
        });


        Thread thread = new Thread(() -> {
            throw new RuntimeException();
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Special exception logic for thread " + thread.getName());
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException();
        });
        thread2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Special exception logic 2 for thread " + thread.getName());
            }
        });

        thread.start();
        thread2.start();

        throw new RuntimeException();
    }



}
