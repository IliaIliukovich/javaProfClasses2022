package lesson20230310;

public interface Playable {

    void play();

    static void m1() {

    }

    default void defaultMethod(){
        System.out.println("This is default method in Playable");
    }

}
