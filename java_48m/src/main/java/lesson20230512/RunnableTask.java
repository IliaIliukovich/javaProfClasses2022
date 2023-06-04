package lesson20230512;

public class RunnableTask {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Some task in progress ...");
            }
        };
        runnable.run();

        Runnable runnable2 = () -> System.out.println("Doing task 2");
        Runnable runnable3 = () -> System.out.println("Doing task 3");
        Runnable runnable4 = () -> System.out.println("Doing task 4");

        runnable2.run();
        new Thread(runnable3).start();

        int a = 10;
//        a++;
        int b = 10;
        Runnable runnableWithVariable = () -> {
//            b++;
            System.out.println(a);
            System.out.println(b);
        };
        runnableWithVariable.run();

    }

}
