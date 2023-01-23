package lesson20230123.multithreading;

public class ThreadWithFlag {

    volatile static boolean isActive = true;

    public static void main(String[] args) {

        System.out.println("Main started");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started");
                long count = 0;
                while (isActive){
                    if (++count % 100000 == 0) {
                        System.out.println(count);
                    }

                }
                System.out.println("Thread finished");
            }
        });
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isActive = false;
        System.out.println("Main finished");

    }



}
