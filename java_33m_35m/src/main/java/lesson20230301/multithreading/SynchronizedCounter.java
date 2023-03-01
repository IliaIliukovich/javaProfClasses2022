package lesson20230301.multithreading;

public class SynchronizedCounter {

    static int count = 0;
    static Object mutex = new Object();

    static class A implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    increment();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void increment() {
            count++;
            System.out.println(count);
        }
    }

//    static class B implements Runnable{
//        @Override
//        public void run() {
//            while (true) {
//                synchronized (mutex) {
//                    count++;
//                    System.err.println(count);
//                }
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }
//        }
//    }

    public static void main(String[] args) {
        A task = new A();
        new Thread(task).start();
        new Thread(task).start();
//        new Thread(new B()).start();


//        synchronized (mutex) {
//            while (true) {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    static synchronized void updateCount() {
//        synchronized (SynchronizedCounter.class) {
            count = 0;
//        }
    }
}
