package lesson20230612;

import java.util.Arrays;
import java.util.List;

public class Factory {

    private int cost;

    private String name;

    private List<Worker> workerList;

    public Factory(int cost, String name, List<Worker> workerList) {
        this.cost = cost;
        this.name = name;
        this.workerList = workerList;
    }

    public static void main(String[] args) {
        List<Worker> workers1 = Arrays.asList(new Worker("Ivan", 35), new Worker("Peter", 55));
        List<Worker> workers2 = Arrays.asList(new Worker("Ivan", 20), new Worker("Peter", 55));


        Factory a = new Factory(100, "Cars factory", workers1);
        Factory b = new Factory(100, "Cars factory", workers2);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        String s = new String("new String");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factory factory = (Factory) o;

        if (cost != factory.cost) return false;
        if (!name.equals(factory.name)) return false;
        return workerList.equals(factory.workerList);
    }

    @Override
    public int hashCode() {
        int result = cost;
        result = 31 * result + name.hashCode();
        result = 31 * result + workerList.hashCode();
        return result;
    }
}
