package lesson20230310;

public class Cat implements Playable{

    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Cat plays with a ball");
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

        cat1.defaultMethod();



    }

    @Override
    public void defaultMethod(){
        System.out.println("This is default method in class cat");
    }



}
