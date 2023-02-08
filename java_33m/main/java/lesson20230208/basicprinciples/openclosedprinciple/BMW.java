package lesson20230208.basicprinciples.openclosedprinciple;

public class BMW extends Car {

    @Override
    public CarService getCarService() {
        return new BMWCarService();
    }
}
