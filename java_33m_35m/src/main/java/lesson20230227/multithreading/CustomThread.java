package lesson20230227.multithreading;

public class CustomThread extends Thread {

    @Override
    public void run(){
        System.out.println(Thread.currentThread() + " started");
        while (!Thread.interrupted()) {
            try {
                System.out.println("Thread works");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " interrupted");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread() + " finished");
    }


}
