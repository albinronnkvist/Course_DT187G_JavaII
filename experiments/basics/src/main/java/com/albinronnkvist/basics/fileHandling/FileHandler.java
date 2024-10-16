package com.albinronnkvist.basics.fileHandling;

import java.io.*;
import java.util.Scanner;

public class FileHandler {
    private final String baseFolder = "target/generated-files" + File.separator;

    public void createFileWithBufferedWriter(String filename) {
        var file = new File(baseFolder + filename);
        file.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is the second lineeeee.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void createFileWithPrintWriter(String filename) {
        var file = new File(baseFolder + filename);
        file.getParentFile().mkdirs();

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file))))
        {
            writer.println("Hello, World!");
            writer.println("This is the second line.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void readFileLines(String filename) {
        var file = new File(baseFolder + filename);
        if(!file.exists() || !file.isFile()) {
            System.err.println("File does not exist.");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            System.out.println("File lines:");
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

    public void readFileWords(String filename) {
        var file = new File(baseFolder + filename);
        if(!file.exists() || !file.isFile()) {
            System.err.println("File does not exist.");
            return;
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file))))
        {
            System.out.println("File words:");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void listFolderContent() {
        File folder = new File(baseFolder);
        String[] list = folder.list();

        System.out.println("Folder content:");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public boolean deleteFile(String filename) {
        var file = new File(baseFolder + filename);
        return file.delete();
    }
}
