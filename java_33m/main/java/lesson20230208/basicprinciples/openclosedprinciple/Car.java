package lesson20230208.basicprinciples.openclosedprinciple;

public class Car {

    public CarService getCarService() {
        return new CarService();
    }


}
