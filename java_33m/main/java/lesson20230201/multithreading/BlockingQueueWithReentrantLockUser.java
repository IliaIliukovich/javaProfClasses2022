package lesson20230201.multithreading;

public class BlockingQueueWithReentrantLockUser {

    static class Task implements Runnable{

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

    static class Producer implements Runnable {

        private BlockingQueueWithReentrantLock<Runnable> blockingQueue;

        public Producer(BlockingQueueWithReentrantLock<Runnable> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                blockingQueue.put(new Task("Task " + i));
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueueWithReentrantLock<Runnable> blockingQueue;

        public Consumer(BlockingQueueWithReentrantLock<Runnable> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                System.err.println("Tasks in the queue: " + blockingQueue.getCount());
                blockingQueue.take().run();
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueueWithReentrantLock<Runnable> blockingQueue = new BlockingQueueWithReentrantLock<>(3);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
