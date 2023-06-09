package lesson20230609;

public class ExceptionExamples {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("General logic for exception: " + e.getMessage());
            }
        });

        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());
        thread1.setUncaughtExceptionHandler((t, e) -> System.out.println("Special logic for thread1 exception: " + e.getMessage()));

        thread1.start();
        thread2.start();

        throw new RuntimeException("Some error in " + Thread.currentThread().getName());
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " works");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("Some error in " + Thread.currentThread().getName());
        }
    }

}
