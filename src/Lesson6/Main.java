package Lesson6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppData data1 = new AppData("csvTest.csv");
        data1.createNewFile("csvTest2.csv");
    }



}