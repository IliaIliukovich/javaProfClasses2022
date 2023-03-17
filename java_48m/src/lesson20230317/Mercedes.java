package lesson20230317;

public class Mercedes extends Car {
    @Override
    public void specialService() {
        System.out.println("Special service for Mercedes");
    }

    public Mercedes getRandomCar() {
        return new Mercedes();
    }
}
