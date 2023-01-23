package lesson20230123.multithreading;

public class InterruptExample {


    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                System.out.println(Thread.currentThread());
                while (!Thread.interrupted()) {
                    System.out.println(count++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted");
//                        Thread.currentThread().interrupt();
                        break;
                    }

                }
                System.out.println("Thread finished");
            }
        });

        t1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
//        t1.stop();

    }


}
