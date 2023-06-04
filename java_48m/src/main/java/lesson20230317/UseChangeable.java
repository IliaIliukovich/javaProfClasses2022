package lesson20230317;

public class UseChangeable {


    public static void main(String[] args) {
        Changeable changeable1 = new IncreaseValue();
        Changeable changeable2 = new DecreaseValue();
        Changeable changeable3 = new Multiply();

        System.out.println(changeable1.change(10, 1));
        System.out.println(changeable2.change(10, 1));
        System.out.println(changeable3.change(10, 2));


    }

    static final class Multiply extends IncreaseValue {

        @Override
        public int change(int count, int value) {
            return count * value;
        }

    }

}
