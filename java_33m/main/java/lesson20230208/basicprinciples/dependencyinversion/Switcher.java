package lesson20230208.basicprinciples.dependencyinversion;

public class Switcher {

    private Switchable lamp;

    public Switcher(Switchable lamp) {
        this.lamp = lamp;
    }

    public void switchOn(){
        lamp.on(true);
    }

    public void switchOff(){
        lamp.on(false);
    }


    public static void main(String[] args) {

        Switcher switcher = new Switcher(new Lamp());
        switcher.switchOn();

        switcher = new Switcher(new LightBulb());
        switcher.switchOn();

    }

}
