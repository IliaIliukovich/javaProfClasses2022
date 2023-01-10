import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray {

    public static void main(String[] args) {
        StringArrayList stringArrayList = new StringArrayList();
        stringArrayList.printElements();
        stringArrayList.add("a");
        stringArrayList.printElements();
        stringArrayList.add("b");
        stringArrayList.printElements();
        stringArrayList.add("c");
        stringArrayList.printElements();
        stringArrayList.add("d");
        stringArrayList.printElements();

        ArrayList<String> list = new ArrayList<>();

        Iterator<String> iterator = stringArrayList.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        for (String st: stringArrayList) {
            System.out.println(st);
        }
    }


}
