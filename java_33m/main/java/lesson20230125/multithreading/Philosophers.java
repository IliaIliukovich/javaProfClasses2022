package lesson20230125.multithreading;

import java.util.Random;

public class Philosophers {

    static class Fork {

        private final Integer id;

        public Fork(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Fork{" + "id='" + id + '\'' + '}';
        }
    }

    static class Philosopher {

        private final String name;
        private final Fork fork1;
        private final Fork fork2;
        private static final Random random = new Random();

        public Philosopher(String name, Fork fork1, Fork fork2) {
            this.name = name;
            this.fork1 = fork1;
            this.fork2 = fork2;
        }

        @Override
        public String toString() {
            return "Philosopher{" + "name='" + name + '\'' + '}';
        }

        public void atTheTable() {
            while (true) {
                snack();
                think();
            }
        }

        public void snack() {
            synchronized (fork1) {
                synchronized (fork2) {
                eatSpaghetti(fork1);
                eatSpaghetti(fork2);
                }
            }
        }

        public void think() {
            try {
                System.err.println(this + " thinks about important things... ");
                Thread.sleep(random.nextInt(50));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void eatSpaghetti(Fork fork) {
            try {
                System.out.println(this + " eats spaghetti with " + fork);
                Thread.sleep(random.nextInt(50));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);

        Philosopher philosopher1 = new Philosopher("Plato", fork1, fork2);
        Philosopher philosopher2 = new Philosopher("Socrates", fork2, fork3);
        Philosopher philosopher3 = new Philosopher("Aristotle", fork3, fork1);

        new Thread(philosopher1::atTheTable).start();
        new Thread(philosopher2::atTheTable).start();
        new Thread(philosopher3::atTheTable).start();
    }

}
