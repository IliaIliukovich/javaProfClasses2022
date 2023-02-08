package lesson20230208.basicprinciples.openclosedprinciple;

public class Mercedes extends Car {

    @Override
    public CarService getCarService() {
        return new MercedesCarService();
    }
}
