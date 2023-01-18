package lesson20230118.multithreading;

public class Task1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread starts " + Thread.currentThread());

        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread ends " + Thread.currentThread());

    }
}
