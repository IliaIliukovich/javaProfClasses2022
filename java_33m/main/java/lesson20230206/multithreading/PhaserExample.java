package lesson20230206.multithreading;

import java.util.concurrent.Phaser;

public class PhaserExample {

// Крайне простой пример работы Phaser, который демонстрирует, что мы можем поделить поток на фазы и
// контролировать положение исполнения в рамках каждого потока
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1);
        int curPhase;

        System.out.println("Starting threads");

        new Thread(new MyThread(phaser, "A")).start();
        new Thread(new MyThread(phaser, "B")).start();
        new Thread(new MyThread(phaser, "C")).start();


        curPhase = phaser.getPhase();

        // ожидаем завершения всеми потоками первой фазы
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");


        curPhase = phaser.getPhase();

        // ожидаем завершения всеми потоками второй фазы
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");

        // снимаем основной поток исполнения с регистрации
        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) System.out.println("Phaser is terminated");
    }

    static class MyThread implements Runnable {
        Phaser phaser;
        String name;

        public MyThread(Phaser phaser, String name) {

            this.phaser = phaser;
            this.name = name;

            phaser.register();
        }

        @Override
        public void run() {
            System.out.println("Thread " + name + " is starting first phase");
            phaser.arriveAndAwaitAdvance();

            // небольшая пауза, чтобы не нарушать порядок вывода. Только для демонстрации, в реальности этого может не быть
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread " + name + " is starting second phase");
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread " + name + " is starting third phase");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
