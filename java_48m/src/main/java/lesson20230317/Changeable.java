package lesson20230317;

public sealed interface Changeable permits IncreaseValue, DecreaseValue {

    int change(int count, int value);

}
