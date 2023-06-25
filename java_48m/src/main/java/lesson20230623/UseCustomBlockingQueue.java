package lesson20230623;

public class UseCustomBlockingQueue {

    static class Producer extends Thread {

        private CustomBlockingQueue<String> queue;

        public Producer(CustomBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                queue.put("data " + j);
                System.out.println(Thread.currentThread().getName() + " added new data, queue size = " + queue.size());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Consumer extends Thread {

        private CustomBlockingQueue<String> queue;

        public Consumer(CustomBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                String takenData = queue.take();
                System.out.println(Thread.currentThread().getName() + " got data: " + takenData);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public static void main(String[] args) {
        CustomBlockingQueue<String> queue = new CustomBlockingQueue<>(5);
        Producer producer = new Producer(queue);
//        Producer producer2 = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
//        producer2.start();
        consumer.start();
    }


}
