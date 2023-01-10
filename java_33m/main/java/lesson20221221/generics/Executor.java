package lesson20221221.generics;

public class Executor <T, V extends Number> {

    T t;
    V v;

    public void execute(T t) {
        // some actions
        System.out.println("Executor executes on " + t.getClass().getSimpleName() + " returns " + t);
    }

    public T getT() {
        return t;
    }

    public <R,Q> void doSometh(R r, Q q){
        System.out.println("doSometh on " + r.getClass().getSimpleName() + " returns " + r);
        System.out.println("doSometh on " + q.getClass().getSimpleName() + " returns " + q);
    }

}
