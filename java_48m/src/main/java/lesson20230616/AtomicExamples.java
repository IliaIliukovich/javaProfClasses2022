package lesson20230616;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExamples {
        static int value = 10;
        static AtomicInteger atomicInteger = new AtomicInteger(value);

    public static void main(String[] args) {
        new Thread(() -> increment()).start();
        new Thread(() -> increment()).start();

    }

    private static void increment() {
        while (true) {
            int i = atomicInteger.incrementAndGet();
            System.out.println(i);
//            boolean isChanged = false;
//            do {
//                int tmp = atomicInteger.get();
//                int old = tmp;
//                tmp++;
//                System.out.println(tmp);
//                isChanged = atomicInteger.compareAndSet(old, tmp);
//                if (!isChanged) System.out.println("!!!!!!!!!");
//            } while (!isChanged);
        }
    }


}
