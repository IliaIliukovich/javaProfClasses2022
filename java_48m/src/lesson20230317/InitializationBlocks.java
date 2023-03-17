package lesson20230317;

public class InitializationBlocks {

    static int i = 1;

    int j = 2;

    {
        System.out.println("In non-static block");
        j = 3;
    }

    static {
        System.out.println("In static block");
        i = 10;
    }

    public InitializationBlocks(int j) {
        System.out.println("In constructor");
        this.j = j;
    }

    public static void main(String[] args) {
        InitializationBlocks initializationBlocks = new InitializationBlocks(4);
        System.out.println(initializationBlocks.j);
        System.out.println(InitializationBlocks.i);

    }


}
