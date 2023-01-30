package lesson20230125.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExamples {

    static String s = "Some string 1";
    static AtomicInteger  counter = new AtomicInteger(0);


    public static void main(String[] args) {

        System.out.println("_____AtomicReference example_____");
        AtomicReference<String> reference = new AtomicReference<>(s);

        Thread thread = new Thread(() -> {
            reference.getAndSet("Some string 2");
            s = "Some string 3";

            System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + reference.get());
            System.out.println(s);
        });

        thread.start();

        System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + reference.get());
        System.out.println(s);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + reference.get());
        System.out.println(s);

        System.out.println("_____AtomicReference example end______");

        System.out.println("AtomicInteger example for increment:");

        Thread t1 = new Thread(() -> {
            while (true) {
//                System.out.println(counter.incrementAndGet());
                // решение вместо incrementAndGet - на основе принципа compare and swap
                boolean isUpdated = false;
                int tmp = 0;
                while (!isUpdated) {
                    tmp = counter.get();
                    int oldValue = tmp;
                    tmp++;
                    isUpdated = counter.compareAndSet(oldValue, tmp);
                }
                System.out.println(tmp);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }});

        Thread t2 = new Thread(() -> {
            while (true) {
                System.err.println(counter.incrementAndGet());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }});

        t1.start();
        t2.start();

    }


}
