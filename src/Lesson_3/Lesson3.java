package Lesson_3;

public class Lesson3 {
    public static void main(String[] args) {

        //Task 6
        int[] massiveSixthTask = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < massiveSixthTask.length; i++) {
            if (massiveSixthTask[i] == 0) massiveSixthTask[i] = 1;
            else massiveSixthTask[i] = 0;
        }


        //Task 7
        int[] massiveSeventhTask = new int[100];
        for (int i = 0; i < 100; i++) {
            massiveSeventhTask[i] = i + 1;
        }


        //Task 8
        int[] massiveEighthTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < massiveEighthTask.length; i++) {
            if (massiveEighthTask[i] < 6) {
                massiveEighthTask[i] *= 2;
            }
        }


        //Task 9
        int[][] massiveNinthTask = new int[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (row == col) {
                    massiveNinthTask[row][col] = 1;
                    continue;
                }
                if (row + col == 9) {
                    massiveNinthTask[row][col] = 1;
                }
            }
        }
    }

    //Task 1
    static boolean isSumBetween10and20(int valueFirst, int valueSecond) {
        int sum = valueFirst + valueSecond;
        return sum > 10 && sum < 20;
    }

    //Task 2
    static void isValuePositiveOrNegativePrint(int value) {
        if (value >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //Task 3
    static boolean isValueNegative(int value) {
        return value < 0;
    }

    //Task 4
    static void printAndRepeatString(String str, int quantity) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(str);
        }
    }

    //Task 5
    static boolean isYearLeap(int year) {
        if (year % 400 == 0) return true;
        if (year % 4 == 0 && year % 100 != 0) return true;
        else return false;
    }

    //Task 10
    static int[] massiveWithValue(int len, int initialValue) {
        int[] massive = new int[len];
        for (int i = 0; i < len; i++) {
            massive[i] = initialValue;
        }
        return massive;
    }
}