package lesson20230317;

public final class DecreaseValue implements Changeable {
    @Override
    public int change(int count, int value) {
        return count - value;
    }
}
