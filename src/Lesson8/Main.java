package Lesson8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] words = {"ab", "ab", "ac", "ad", "ae", "ab", "ae", "af", "ag", "ak"};
        Map<String, Integer> wordsMap = new HashMap<>();

        for (String str : words
        ) {
            if (!wordsMap.containsKey(str)) {
                wordsMap.put(str, 1);
            } else {
                int count = wordsMap.get(str);
                count++;
                wordsMap.put(str, count);
            }
        }
        System.out.println(wordsMap.keySet());


        for (Map.Entry entry : wordsMap.entrySet()
        ) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Кошкин", 89001234567L);
        phoneBook.add("Кошкин", 89008901234L);
        phoneBook.add("Собачкина", 89000000000L);

        phoneBook.get("Кошкин");
        phoneBook.get("Собачкина");
    }


}


