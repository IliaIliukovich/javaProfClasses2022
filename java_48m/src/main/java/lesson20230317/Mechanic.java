package lesson20230317;

public class Mechanic {

    public void service(Car car){
        car.commonService();

        car.specialService();

//        if (car.getClass() == Tesla.class){
//            System.out.println("Special service for Tesla");
//        } else if (car.getClass() == Nissan.class){
//            System.out.println("Special service for Nissan");
//        } else if (car.getClass() == BMW.class) {
//            System.out.println("Special service for BMW");
//        } else if (car.getClass() == BMW2.class) {
//            System.out.println("Special service for BMW2");
//        }

        car.washCar();
    }



    public static void main(String[] args) {
        Mechanic mechanic = new Mechanic();
        Car car = new BMW2();
        mechanic.service(car);
    }

}
