package lesson20230130.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();

    public void put(T item) {
        synchronized (queue) {
            queue.add(item);
            queue.notify();
        }
    }

    public T take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }



}
