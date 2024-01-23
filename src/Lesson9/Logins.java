package Lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> logins = new ArrayList<>();
        while (true) {
            String line = in.nextLine();
            if (line.isEmpty()) break;
            logins.add(line);
        }

        logins.stream().filter(s -> s.charAt(0) == 'f').forEach(s -> System.out.print(s + " "));
    }
}
