package lesson20230630;

public class Custom {

    private int value;

    public Custom(int value) {
        this.value = value;
    }

    @Deprecated
    public int process(int data) {
        System.out.println("Processing with input data: " + data);
        return data + 10;
    }

    private void processInner() {
        System.out.println("Processing with inner data: " + value);
    }
}
