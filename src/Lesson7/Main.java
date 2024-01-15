package Lesson7;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] array1 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array1[i][j] = String.valueOf(i + j);
            }
        }

        String[][] array2 = new String[5][2];

        String[][] array3 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array3[i][j] = String.valueOf(i + j);
            }
        }
        array3[2][2] = "exception";

        metod(array1);


        try {
            metod(array2);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        try {
            metod(array3);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public static void metod(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) throw new MyArraySizeException();
        for (String[] line : array
        ) {
            if (line.length != 4) throw new MyArraySizeException();
        }

        int sum = 0;
        int rowEx = 0;
        int colEx = 0;

        try {
            for (int i = 0; i < 4; i++) {
                rowEx = i;
                for (int j = 0; j < 4; j++) {
                    colEx = j;
                    sum += Integer.parseInt(array[i][j]);
                }
            }

        } catch (Exception e) {
            throw new MyArrayDataException(rowEx, colEx);
        }
        System.out.println(sum);
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("неверный размер массива");
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super("неверные данные в ячейке " + row + " " + col);
    }
}