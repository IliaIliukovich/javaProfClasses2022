package lesson20230306.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private static AtomicInteger counter = new AtomicInteger(0);


    public static void main(String[] args) {

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    System.out.println(counter.incrementAndGet());
                    // код ниже - фактически реализация атомарной операции incrementAndGet()
                    boolean success = false;
                    while (!success) {
                        int current = counter.get();
                        int old = current;
                        current++;
                        success = counter.compareAndSet(old, current);
                        if (!success) {
                            System.out.println("!!!");
                        }
                        System.out.println(current);
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(counter.incrementAndGet());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();



    }


}
