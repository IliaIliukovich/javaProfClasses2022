package lesson20230907;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindTicketsInOrder {

    // Найти маршрут из заданного списка билетов
    //Учитывая список билетов, найти маршрут по порядку, используя данный список.
    //Вход:
    //«Berlin» -> «London»
    //«Tokyo» -> «Seoul»
    //«Mumbai» -> «Berlin»
    //«Seoul» -> «Mumbai»
    //
    //Выход:
    //Tokyo->Seoul, Seoul->Mumbai, Mumbai->Berlin, Berlin->London

    public static void main(String[] args) {
        Map<String, String> input = new HashMap<>();
        input.put("Berlin", "London");
        input.put("Tokio", "Seoul");
        input.put("Mumbai", "Berlin");
        input.put("Seoul", "Mumbai");

        printTicketsInOrder(input);
    }

    private static void printTicketsInOrder(Map<String, String> input) {

        // find the starting point
        Map<String, String> reverseOrder = new HashMap<>();
        Set<Map.Entry<String, String>> entries = input.entrySet();
        for (Map.Entry<String, String> e : entries) {
            reverseOrder.put(e.getValue(), e.getKey());
        }
        String start = reverseOrder.keySet().iterator().next();
        String first = start;

        while (start != null) {
            first = start;
            start = reverseOrder.get(start);
        }
        System.out.println("Starting point: " + first);

        // traverse the route and print
        while (first != null){
            String value = input.get(first);
            System.out.println(first + " ---> " + value);
            first = value;
        }
    }


}
