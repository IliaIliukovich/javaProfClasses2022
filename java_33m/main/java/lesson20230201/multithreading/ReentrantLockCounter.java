package lesson20230201.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {

    static int counter = 0;

    Lock lock = new ReentrantLock(true);

    public void increment() {
        lock.lock();
        try {
            counter++;
            counter = counter / 0; // благодаоя блоку finally поток освободит lock даже в случае exception
        } finally {
            lock.unlock();
        }
    }

    public int get(){
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockCounter counter1 = new ReentrantLockCounter();

        new Thread(() -> System.out.println(counter1.get())).start();
        counter1.increment();

    }




}
