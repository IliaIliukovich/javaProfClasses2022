package lesson20230123.multithreading;

public class DaemonExample {


    public static void main(String[] args) {

        System.out.println("Main start");
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        };


        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

        Thread t3 = new Thread(
                () -> {

                    System.out.println(Thread.currentThread());
                    int count = 0;
                    while (true) {
                        System.out.println(count++);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
        );
        t3.setDaemon(true);
        t3.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Some serious error");

//        System.out.println("Main end");
    }


}
