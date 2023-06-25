package lesson20230623;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<T> {

    private final int size;
    private final Queue<T> queue;
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition conditionToTake = lock.newCondition();
    private final Condition conditionToAdd = lock.newCondition();

    public CustomBlockingQueue(int size) {
        this.size = size;
        queue = new ArrayDeque<>(size);
    }

    public void put(T element){
        lock.lock();
        try {
            while (queue.size() >= size){
                try {
                    conditionToAdd.await();
                } catch (InterruptedException ignore) {
                }
            }
            queue.add(element);
            conditionToTake.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    conditionToTake.await();
                } catch (InterruptedException ignore) {
                }
            }
            conditionToAdd.signal();
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

}
