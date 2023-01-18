package lesson20230118.multithreading;

public class Task2 extends Thread {

    Thread thread;

    public Task2(String name, Thread thread) {
        super(name);
        this.thread = thread;
    }

    @Override
    public void run(){

//        try {
//            thread.join();

            System.err.println("Thread starts " + Thread.currentThread());

            for (int i = 10; i > 0; i--) {
                System.err.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.err.println("Thread ends " + Thread.currentThread());
    }

}
