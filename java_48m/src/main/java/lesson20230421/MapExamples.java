package lesson20230421;

import java.util.*;

public class MapExamples {


    public static void main(String[] args) {

        Map<Integer, String> map = new TreeMap<>();

        map.put(3, "B");
        map.put(4, "D");
        map.put(1, "A");
        map.put(2, "B");

        System.out.println(map.get(2));

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> s : set) {
            System.out.println("Key = " + s.getKey() + " value = " + s.getValue());
        }

        String words = "Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say\n" + "that they were perfectly normal, thank you very much. They were the last\n" + "people you'd expect to be involved in anything strange or mysterious,\n" + "because they just didn't hold with such nonsense.\n" + "Mr. Dursley was the director of a firm called Grunnings, which made\n" + "drills. He was a big, beefy man with hardly any neck, although he did\n" + "have a very large mustache. Mrs. Dursley was thin and blonde and had\n" + "nearly twice the usual amount of neck, which came in very useful as she\n" + "spent so much of her time craning over garden fences, spying on the\n" + "neighbors. The Dursleys had a small son called Dudley and in their\n" + "opinion there was no finer boy anywhere.\n" + "The Dursleys had everything they wanted, but they also had a secret, and\n" + "their greatest fear was that somebody would discover it. They didn't\n" + "think they could bear it if anyone found out about the Potters. Mrs.\n" + "Potter was Mrs. Dursley's sister, but they hadn't met for several years;\n" + "in fact, Mrs. Dursley pretended she didn't have a sister, because her\n" + "sister and her good-for-nothing husband were as unDursleyish as it was\n" + "possible to be. The Dursleys shuddered to think what the neighbors would\n" + "say if the Potters arrived in the street. The Dursleys knew that the\n" + "Potters had a small son, too, but they had never even seen him. This boy\n" + "was another good reason for keeping the Potters away; they didn't want\n" + "Dudley mixing with a child like that.\n" + "When Mr. and Mrs. Dursley woke up on the dull, gray Tuesday our story\n" + "starts, there was nothing about the cloudy sky outside to suggest that\n" + "strange and mysterious things would soon be happening all over the\n" + "country. Mr. Dursley hummed as he picked out his most boring tie for\n" + "work, and Mrs. Dursley gossiped away happily as she wrestled a screaming\n" + "Dudley into his high chair.\n" + "None of them noticed a large, tawny owl flutter past the window.\n" + "At half past eight, Mr. Dursley picked up his briefcase, pecked Mrs.\n" + "Dursley on the cheek, and tried to kiss Dudley good-bye but missed,";

        Map<String, Integer> dictionary = new TreeMap<>();
        String[] strings = words.split("\\W");
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if (dictionary.containsKey(key)) {
                dictionary.put(key, dictionary.get(key) + 1);
            } else {
                dictionary.put(key, 1);
            }
        }

        List<Word> wordList = new ArrayList<>();
        for (Map.Entry<String, Integer> word : dictionary.entrySet()) {
            wordList.add(new Word(word.getValue(), word.getKey()));
        }
        wordList.sort(Word::compareTo);
        for (Word w : wordList) {
            System.out.println(w);
        }


//        Queue<Word> count = new PriorityQueue<>();
//        for (Map.Entry<String, Integer> word : dictionary.entrySet()) {
//            System.out.println(word);
//            count.add(new Word(word.getValue(), word.getKey()));
//        }

//        int n = count.size();
//        for (int i = 0; i < n; i++) {
//            System.out.println(count.poll());
//        }

    }

    public static class Word implements Comparable<Word> {

        int count;
        String value;

        public Word(int count, String value) {
            this.count = count;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Word{" + "count=" + count + ", value='" + value + '\'' + '}';
        }

        @Override
        public int compareTo(Word o) {
            return o.count - count;
        }
    }



}
