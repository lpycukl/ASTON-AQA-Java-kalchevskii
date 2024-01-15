package Lesson6;

import java.io.*;
import java.util.Arrays;

public class AppData {
    private final String[] header;
    private final int[][] data;

    public AppData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            //чтение заголовков
            String firstLine;
            firstLine = br.readLine();
            String[] headers = firstLine.split(";");
            header = new String[headers.length];
            addHeaders(headers);

            //чтение строк с данными
            data = new int[countLines(fileName) - 1][headers.length];
            String line;
            int numberOfLine = 0;
            while ((line = br.readLine()) != null) {
                addValues(stringsToInts(line.split(";")), numberOfLine);
                numberOfLine++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addHeaders(String[] headers) {
        System.arraycopy(headers, 0, header, 0, headers.length);
    }

    public void addValues(int[] values, int numberOfLine) {
        System.arraycopy(values, 0, data[numberOfLine], 0, values.length);
    }

    //подсчет количества строк
    private int countLines(String filename) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(filename))) {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        }
    }

    private int[] stringsToInts(String[] strs) {
        int[] ints = new int[strs.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        return ints;
    }

    public void createNewFile(String fileName) throws IOException {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))) {

            for (int i = 0; i < header.length - 1; i++) {
                br.write(header[i] + ";");
            }

            br.write(header[2] + "\n");

            for (int[] dataLine : data
            ) {
                for (int i = 0; i < dataLine.length - 1; i++) {
                    br.write(dataLine[i] + ";");
                }
                br.write(dataLine[2] + "\n");
            }
        }

    }

}