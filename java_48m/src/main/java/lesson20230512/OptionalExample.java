package lesson20230512;

import java.util.Optional;

public class OptionalExample {


    static class Car {

        private Optional<Insurance> insurance;

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    static class Insurance {

        private String name;

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        Optional<Car> car = Optional.of(new Car());

        Optional<Optional<Insurance>> optionalOptionalInsurance = car.map(Car::getInsurance);
        Optional<Insurance> optionalInsurance = car.flatMap(Car::getInsurance);
        Optional<String> optional = car.flatMap(Car::getInsurance).map(Insurance::getName);
        String name = car.flatMap(Car::getInsurance).map(Insurance::getName).orElse("No insurance present");


    }


}
