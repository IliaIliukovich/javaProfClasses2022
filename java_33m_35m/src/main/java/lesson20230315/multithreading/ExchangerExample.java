package lesson20230315.multithreading;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerExample {

    static Random random = new Random();

    static class BookFan implements Runnable {

        private String book;
        private Exchanger<String> exchanger;

        public BookFan(String book, Exchanger<String> exchanger) {
            this.book = book;
            this.exchanger = exchanger;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " reading book: " + book);
            try {
                Thread.sleep(5000 + random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished book: " + book);

            try {
                setBook(exchanger.exchange(getBook()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " reading book: " + book);
            try {
                Thread.sleep(5000 + random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        BookFan bookFan1 = new BookFan("Harry Potter", exchanger);
        BookFan bookFan2 = new BookFan("Tom Soyer", exchanger);
        new Thread(bookFan1).start();
        new Thread(bookFan2).start();
    }


}
