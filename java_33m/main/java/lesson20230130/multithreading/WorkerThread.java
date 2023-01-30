package lesson20230130.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerThread {

    static class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is being executed by " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is done by " + Thread.currentThread().getName());
        }
    }

    static class ThreadForWork extends Thread   {

        private Queue<Runnable> taskQueue = new LinkedList<>();

        public ThreadForWork() {
            this.start();
        }

        @Override
        public void run(){
            while (true) {
                while (!taskQueue.isEmpty()) {
                    taskQueue.poll().run();
                }
                synchronized (taskQueue) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        public void add(Runnable task) {
            synchronized (taskQueue) {
                taskQueue.add(task);
                taskQueue.notify();
            }
        }

    }


    public static void main(String[] args) {

        System.out.println("Worker thread initializing");
        ThreadForWork thread = new ThreadForWork();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Giving task");
        thread.add(new Task("Task1"));
        thread.add(new Task("Task2"));
        thread.add(new Task("Task3"));

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Giving extra task");
        thread.add(() -> System.out.println("New task"));
    }



}
