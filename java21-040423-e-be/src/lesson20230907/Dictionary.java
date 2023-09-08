package lesson20230907;

import java.util.*;

public class Dictionary {

    public static void main(String[] args) {

        // Составить словарь используемых слов с частотой их употребления
        String inputData = "Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say\n" + "that they " +
                "were perfectly normal, thank you very much. They were the last\n" + "people you'd expect to be involved in anything strange or mysterious,\n" + "because they just didn't hold with such nonsense.\n" + "Mr. Dursley was the director of a firm called Grunnings, which made\n" + "drills. He was a big, beefy man with hardly any neck, although he did\n" + "have a very large mustache. Mrs. Dursley was thin and blonde and had\n" + "nearly twice the usual amount of neck, which came in very useful as she\n" + "spent so much of her time craning over garden fences, spying on the\n" + "neighbors. The Dursleys had a small son called Dudley and in their\n" + "opinion there was no finer boy anywhere.\n" + "The Dursleys had everything they wanted, but they also had a secret, and\n" + "their greatest fear was that somebody would discover it. They didn't\n" + "think they could bear it if anyone found out about the Potters. Mrs.\n" + "Potter was Mrs. Dursley's sister, but they hadn't met for several years;\n" + "in fact, Mrs. Dursley pretended she didn't have a sister, because her\n" + "sister and her good-for-nothing husband were as unDursleyish as it was\n" + "possible to be. The Dursleys shuddered to think what the neighbors would\n" + "say if the Potters arrived in the street. The Dursleys knew that the\n" + "Potters had a small son, too, but they had never even seen him. This boy\n" + "was another good reason for keeping the Potters away; they didn't want\n" + "Dudley mixing with a child like that.\n" + "When Mr. and Mrs. Dursley woke up on the dull, gray Tuesday our story\n" + "starts, there was nothing about the cloudy sky outside to suggest that\n" + "strange and mysterious things would soon be happening all over the\n" + "country. Mr. Dursley hummed as he picked out his most boring tie for\n" + "work, and Mrs. Dursley gossiped away happily as she wrestled a screaming\n" + "Dudley into his high chair.";

        TreeMap<String, Integer> dictionary = new TreeMap<>();
        String[] words = inputData.split("\\W");

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                Integer counter = dictionary.get(word);
                dictionary.put(word, ++counter);
            } else {
                dictionary.put(word, 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = dictionary.entrySet();
        TreeSet<Word> wordSet = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : entries) {
            wordSet.add(new Word(entry.getKey(), entry.getValue()));
        }

        for (Word w : wordSet) {
            System.out.println("Word: '" + w.word + "'. Number of use: " + w.count);
        }
    }

    private static class Word implements Comparable<Word> {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            int result = o.count - this.count;
            if (result != 0) return result;
            return this.word.compareTo(o.word);
        }
    }


}
