package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file1 = new File("FT_9.1.txt");
        FileReader fileReader1 = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(fileReader1);
        File file2 = new File("FT_9.2.txt");
        FileWriter fileReader2 = new FileWriter(file2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader2);

        String line;

        String[] jurnal = new String[10];

        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            jurnal[i] = line;
            i++;
        }
        bufferedReader.close();

        for (int j = 0; j < i; j++) {
            bufferedWriter.write(jurnal[j] + "\n");
        }

        Scanner in = new Scanner(System.in, "ISO-8859-1");
        System.out.print("Input text ");
        String text = in.nextLine();

        try {
            for (int j = 0; j < i; j++) {
                sravn(jurnal[j], text);
            }
            bufferedWriter.write(text);
        } catch (RecordExistsException e) {
            System.out.println(e.getMessage());
        }


        bufferedWriter.close();
    }


    public static void sravn(String lines, String texts) throws RecordExistsException {
        if (lines.equalsIgnoreCase(texts)) {
            throw new RecordExistsException("Запись существует");
        }
    }
}


