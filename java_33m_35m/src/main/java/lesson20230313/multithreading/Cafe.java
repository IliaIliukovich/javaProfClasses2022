package lesson20230313.multithreading;

public class Cafe {

    static Object lunch = new Object();
    static Object guest = new Object();


    static class Visitor implements Runnable{

        @Override
        public void run() {
            System.out.println("Coming in");
            synchronized (guest){
                guest.notify();
            }
            System.out.println("Waiting for lunch");
            synchronized (lunch){
                try {
                    lunch.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Visitor eats");

        }
    }

    static class Chef implements Runnable{

        @Override
        public void run() {
            System.out.println("Waiting for a visitor");
//            boolean shouldBeAwaken = false; // Дополнительный флаг, чтобы избежать пробуждения при threadChef.interrupt()
            synchronized (guest) {
//                while (!shouldBeAwaken) {
                    try {
                        guest.wait();
//                        shouldBeAwaken = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
            }
            System.out.println("Cooking lunch");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Lunch cooked");
            synchronized (lunch){
                lunch.notify();
            }
        }
    }

    public static void main(String[] args) {
        Thread threadChef = new Thread(new Chef());
        threadChef.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        threadChef.interrupt();

        new Thread(new Visitor()).start();
    }


}
