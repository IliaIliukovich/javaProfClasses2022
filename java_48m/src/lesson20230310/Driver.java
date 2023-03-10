package lesson20230310;

public class Driver {

    String name;
    Car car;

    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    private static class Car {
        String name;

        public Car(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Driver driver = new Driver("Tom", new Car("BMW"));



    }

}
