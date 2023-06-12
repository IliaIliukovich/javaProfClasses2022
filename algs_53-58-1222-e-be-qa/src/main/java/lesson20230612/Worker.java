package lesson20230612;

public class Worker {

    private String name;

    private int age;

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;
        return name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result;
    }
}
