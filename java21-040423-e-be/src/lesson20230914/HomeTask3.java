package lesson20230914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HomeTask3 {

//    4. Сгруппируйте слова с одинаковым набором символов
//
//    Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором символов.
//
//    Input: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
//    Output :
//    student, students,
//    cat, act,
//    dog, god,
//    flow, wolf,
//
//    Идея состоит в том, чтобы использовать хеширование. Генерируем ключ для всех слов. Ключ содержит все уникальные символы
//    (размер ключа не более 26 для строчных букв). Мы храним индексы слов как значения для ключа.
//    После того, как мы заполнили все ключи и значения в хеш-таблице, мы можем распечатать результат, пройдя по таблице.

    static final int MAX_CHAR = 26;

    public static void main(String[] args) {
        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
        wordsWithSameCharSet(words);
    }

        // Print all words together with same character sets.
    public static void wordsWithSameCharSet(String[] words) {
        int length = words.length;

        // Stores indexes of all words that have same set of unique characters. unordered_map <string, vector <int> > map;
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        // алгоритм
        // Перебрать все слова
        // если ключ уже есть, получите соответствующее значение
        //      обновить список и добавить в хэш
        // если ключа нет
        //      создайте новый список и добавьте ключ и список в хэш

        for (int i = 0; i < length; i++) {
            String key = getKey(words[i]);

            // if the key is already in the map then get its corresponding value and update the list and put it in the map
            if (map.containsKey(key)) {
                ArrayList<Integer> checkList = map.get(key);
                checkList.add(i);
                map.put(key, checkList);
            } else { // if key is not present in the map then create a new list and add both key and the list
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }
        }

        // print all words that have the same unique character set
        for (Map.Entry<String, ArrayList<Integer>> it : map.entrySet()) {
            ArrayList<Integer> get = it.getValue();
            for (Integer v : get) {
                System.out.print(words[v] + ", ");
            }
            System.out.println();
        }
    }

    // Generates a key from given string. The key contains all unique characters of given string in sorted order consisting of only distinct elements.
    private static String getKey(String str) {
        boolean[] visited = new boolean[MAX_CHAR];
        Arrays.fill(visited, false);

        // store all unique characters of current word in key
        for (int i = 0; i < str.length(); i++) {
            visited[str.charAt(i) - 'a'] = true;
        }

        StringBuilder key = new StringBuilder();

        for (int i = 0; i < MAX_CHAR; i++) {
            if (visited[i]) {
                key.append((char) ('a' + i));
            }
        }

        return key.toString();
    }

}
