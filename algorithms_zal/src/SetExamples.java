import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {

    public static void main(String[] args) {
        Comparator<Car> rotatedComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int ourVin = o1.getVin();
                int anotherVin = o2.getVin();
                return Integer.compare(anotherVin, ourVin);
            }
        };
        NavigableSet<Car> sortedCars = new TreeSet<>(rotatedComparator);
        sortedCars.add(new Car(7, "Volvo", "S60"));
        sortedCars.add(new Car(5, "Ford", "Focus"));
        sortedCars.add(new Car(9, "VW", "Golf"));
        sortedCars.add(new Car(9, "Mercedes", "550"));
        sortedCars.add(new Car(1, "Mitsubishi", "Lancer"));

        /*sortedCars.forEach(System.out::println);
        System.out.println("------------------------------------------");
        System.out.println(sortedCars.pollFirst());
        System.out.println(sortedCars.pollLast());*/

        Set<Car> cars = new LinkedHashSet<>();
        cars.add(new Car(11, "BMW", "X6"));
        cars.add(new Car(11, "Volvo", "S40"));
        cars.add(new Car(50, "Opel", "Astra"));
        cars.add(new Car(76, "Nissan", "Almera"));
        cars.add(new Car(63, "Volvo", "XS90"));

        //cars.forEach(System.out::println);

        int x = 6;
        int y = 2;

        int result = x > y ? 1 : -1;

        System.out.println(result);
    }

    private static final class Car implements Comparable<Car> {
        private int vin;
        private String make;
        private String model;

        public Car(int vin, String make, String model) {
            this.vin = vin;
            this.make = make;
            this.model = model;
        }

        public int getVin() {
            return vin;
        }

        public void setVin(int vin) {
            this.vin = vin;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        @Override
        public int compareTo(Car o) {
            int ourVin = this.getVin();
            int anotherVin = o.getVin();
            return Integer.compare(ourVin, anotherVin);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return vin == car.vin;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vin);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "vin=" + vin +
                    ", make='" + make + '\'' +
                    ", model='" + model + '\'' +
                    '}';
        }
    }
}
