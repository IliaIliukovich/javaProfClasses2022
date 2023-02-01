package lesson20230201.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWithReentrantLock<T> {

    private Queue<T> queue;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private int size;

    public BlockingQueueWithReentrantLock(int size) {
        this.queue = new ArrayDeque<>(size);
        this.size = size;
    }

    public void put(T item) {
        lock.lock();
        try {
            while (queue.size() == size) {
                condition2.awaitUninterruptibly();
            }
            queue.add(item);
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition1.awaitUninterruptibly();
            }
            condition2.signal();
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }



}
