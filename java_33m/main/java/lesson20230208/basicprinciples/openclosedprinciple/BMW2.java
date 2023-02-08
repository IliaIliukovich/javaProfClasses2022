package lesson20230208.basicprinciples.openclosedprinciple;

public class BMW2 extends BMW {

    // This code might violate Liskov substitution principle
    @Override
    public CarService getCarService() {
        throw new RuntimeException("Not yet implemented");
    }

}
