package lesson20230526;

public class MyGenericClass<T, P, Q> {

    private T objectT;

    public void action(P objectP) {
        System.out.println("Action method with " + objectP.getClass());

        if (objectP instanceof String) {
            String s = (String) objectP;
            System.out.println("String action " + s.toUpperCase());
//        } else if(objectP.getClass().equals(Number.class)){
        } else if(objectP instanceof Number){
            Number d = (Number) objectP;
            System.out.println("Number action " + (d.intValue() + 1));
        }

    }

    public Q action2(){
        return null;
    }

    public <M, N> void action3(M objectM, N objectN){

    }






}
