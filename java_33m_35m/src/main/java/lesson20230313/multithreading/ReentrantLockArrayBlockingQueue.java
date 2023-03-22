package lesson20230313.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockArrayBlockingQueue<T> {

    private Queue<T> queue;
    private Lock lock = new ReentrantLock(true);
    private Condition queueIsEmpty = lock.newCondition();
    private Condition queueIsFull = lock.newCondition();
    private int size;

    public ReentrantLockArrayBlockingQueue(int size) {
        this.size = size;
        this.queue = new  ArrayDeque<>(size);
    }

    public void put(T item) {
        lock.lock();
        try {
            while (queue.size() >= size) {
                queueIsFull.awaitUninterruptibly();
            }
            queue.add(item);
            queueIsEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                queueIsEmpty.awaitUninterruptibly();
            }
            queueIsFull.signal();
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
