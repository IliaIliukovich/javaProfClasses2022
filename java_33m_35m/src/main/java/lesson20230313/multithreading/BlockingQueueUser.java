package lesson20230313.multithreading;

public class BlockingQueueUser {

    static class Producer implements Runnable {

        private MyBlockingQueue<String> queue;

        public Producer(MyBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                queue.put(Thread.currentThread().getName() + ": Message" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Consumer implements Runnable {

        private MyBlockingQueue<String> queue;

        public Consumer(MyBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                String message = queue.take();
                System.out.println(Thread.currentThread().getName() + " received message: " + message +
                        " Elements in queue:" + queue.getSize());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        MyBlockingQueue<String> queue = new MyBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }



}
