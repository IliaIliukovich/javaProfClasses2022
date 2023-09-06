package lesson20230905;

public class CatHouse {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Tom", 1, "black", true);
        Cat cat2 = new Cat("Tom", 1, "black", false);
//        Cat cat3 = cat1;
        System.out.println(cat1 == cat2);
//        System.out.println(cat1 == cat3);

        System.out.println(cat1.equals(cat2));
//        System.out.println(cat1.equals(cat3));

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
//        System.out.println(cat3.hashCode());




    }


}
