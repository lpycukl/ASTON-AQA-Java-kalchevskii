package Lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    Map<String, List<Long>> phones = new HashMap<>();

    public void add(String name, Long number) {
        if (!phones.containsKey(name)) {
            List<Long> numbers = new ArrayList<>();
            numbers.add(number);
            phones.put(name, numbers);
        } else {
            List<Long> numbers = phones.get(name);
            numbers.add(number);
            phones.put(name, numbers);
        }
    }

    public void get(String name) {
        System.out.println(name + ": " + phones.get(name));
    }
}
