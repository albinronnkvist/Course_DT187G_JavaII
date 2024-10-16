package com.albinronnkvist.basics.fileHandling;

import java.io.*;
import java.util.Scanner;

public class FileHandler {
    public void CreateFileWithBufferedWriter(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is the second line.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void CreateFileWithPrintWriter(String filename) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename))))
        {
            writer.println("Hello, World!");
            writer.println("This is the second line.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void ReadFileLines(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            var line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void ReadFileWords(String filename) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename))))
        {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
