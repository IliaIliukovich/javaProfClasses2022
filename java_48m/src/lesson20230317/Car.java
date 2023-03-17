package lesson20230317;

public abstract class Car {

    public void commonService() {
        System.out.println("Common service for a car");
    }

    public void washCar() {
        System.out.println("Washing a car");
    }

    public abstract void specialService();

    public Car getRandomCar() {
        return new Car() {
            @Override
            public void specialService() {
                System.out.println("Service for random car");
            }
        };
    }
}
