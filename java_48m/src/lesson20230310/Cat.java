package lesson20230310;

public class Cat {

    String name;

    public Cat(String name) {
        this.name = name;
    }

    public class Kitten {
        private String name;

        public Kitten(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom");

        Kitten kitten1 = cat1.new Kitten("Vasya");
        Kitten kitten2 = cat1.new Kitten("Marusia");
        Kitten kitten3 = cat1.new Kitten("Petya");

        String kittenName = kitten1.name;

        Cat cat2 = new Cat("Jerry");

        Kitten kitten4 = cat2.new Kitten("Vasya");
        Kitten kitten5 = cat2.new Kitten("Marusia");
        Kitten kitten6 = cat2.new Kitten("Petya");


    }



}
