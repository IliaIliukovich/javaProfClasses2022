package lesson20230313.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();


    public void put(T item) {
        lock.lock();
        try {
            queue.add(item);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        } finally {
            lock.unlock();
        }

    }

    public int getSize(){
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }


}
