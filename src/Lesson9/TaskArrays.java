package Lesson9;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskArrays {
    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(1000);
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = random.nextInt(500);
        }

        EvenCount(randomNumbers);

        String[] words = {"Highload", "High", "Load", "Highload" };
        String[] empty = {};

        int quantityOfHigh = (int) Stream.of(words).filter(w -> w.contains("High")).count();
        System.out.println("High встречается " + quantityOfHigh);

        String first;
        String last;
        first = findFirst(words);
        last = findLast(words);
        System.out.println("Первый эллемент " + first);
        System.out.println("Последний эллемент " + last);
        first = findFirst(empty);
        last = findLast(empty);
        System.out.println("Первый эллемент " + first);
        System.out.println("Последний эллемент " + last);

        String[] sort = {"f10", "f15", "f2", "f4", "f4" };
        ArrayList<String> afterSort = new ArrayList<>();
        Stream.of(sort).sorted(new FComporator()).forEach(afterSort::add);
        System.out.println(afterSort);
    }

    static public void EvenCount(int[] numbers) {
        int quantityOfChet = (int) IntStream.of(numbers).filter(w -> w % 2 == 0).count();
        System.out.println("четных чисел " + quantityOfChet);
    }

    static public String findFirst(String[] words) {
        if (words.length == 0) return "0";
        else return Stream.of(words).findFirst().get();
    }

    static public String findLast(String[] words) {
        if (words.length == 0) return "0";
        else return Stream.of(words).skip(words.length - 1).findAny().get();
    }

}


class FComporator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int o1Number = Integer.parseInt(o1.substring(1));
        int o2Number = Integer.parseInt(o2.substring(1));
        if (o1Number > o2Number) return 1;
        if (o1Number == o2Number) return 0;
        if (o1Number < o2Number) return -1;
        else return 0;
    }
}