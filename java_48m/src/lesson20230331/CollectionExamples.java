package lesson20230331;

import java.util.*;

public class CollectionExamples {


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        Object o = list.get(0);
        String s = (String) o;

        Collection<Integer> collection;
        Iterable<Character> iterable;

        List<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();

        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.poll();

//        List<String> stringList = Arrays.asList("A", "B", "C", "D", "E");
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }

        for (String string : stringList) {
            System.out.println(string);
        }

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            if (current.equals("C")) {
                iterator.remove();
            }
            System.out.println(current);
        }

        System.out.println(stringList.size());
        for (String string : stringList) {
            System.out.println(string);
        }


        int[] ints = new int[]{1, 2, 3, 4, 5};
        CustomCollection customCollection = new CustomCollection(ints);

        for (int element : customCollection) {
            System.out.println(element);
        }

        Set<String> set = new TreeSet<>();
        set.add("One");
        set.add("One");
        set.add("Two");
        set.add("Three");
        System.out.println(set);

    }
}
