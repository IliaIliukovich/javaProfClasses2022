package lesson20230313.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();


    public void put(T item) {
        synchronized (queue) {
            queue.add(item);
            queue.notify();
        }
    }

    public T take(){
        synchronized (queue) {
            while (queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }

    public int getSize(){
        synchronized (queue) {
            return queue.size();
        }
    }


}
