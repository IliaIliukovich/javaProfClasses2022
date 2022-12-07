package lesson07122022.lambdas;

public class FootballPlayer implements Playable{

    private String name;

    @Override
    public void play() {
        System.out.println("I play football!");
    }
}
