package lesson20230310;

public class UseSpecialClass {


    public static void main(String[] args) {

        SpecialClass specialClass = SpecialClass.generateClass("Tom");
        System.out.println(specialClass);

        System.out.println(SpecialClass.generateRandomClass());
        System.out.println(SpecialClass.generateRandomClass());
        System.out.println(SpecialClass.generateRandomClass());
        System.out.println(SpecialClass.generateRandomClass());
        System.out.println(SpecialClass.generateRandomClass());
        System.out.println(SpecialClass.generateRandomClass());

        SpecialClass.StaticClass staticClass = new SpecialClass.StaticClass();
        staticClass.setName("Static class name");




    }


}
