package lesson20230130.multithreading;

public class BlockingQueueUser {

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

        private BlockingQueue<Runnable> blockingQueue;

        public Producer(BlockingQueue<Runnable> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                blockingQueue.put(new Task("Task " + i));
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<Runnable> blockingQueue;

        public Consumer(BlockingQueue<Runnable> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                blockingQueue.take().run();
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Runnable> blockingQueue = new BlockingQueue<>();
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
