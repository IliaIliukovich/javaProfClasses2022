package lesson20230317;

public sealed class IncreaseValue implements Changeable permits UseChangeable.Multiply {


    @Override
    public int change(int count, int value) {
        return count + value;
    }
}
