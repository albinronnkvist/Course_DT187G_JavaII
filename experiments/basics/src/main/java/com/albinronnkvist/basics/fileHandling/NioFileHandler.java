package com.albinronnkvist.basics.fileHandling;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class NioFileHandler {
    private final Path baseFolder = Paths.get("target", "generated-files");

    public NioFileHandler() {
        try {
            Files.createDirectories(baseFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFileWithBufferedWriter(String filename) {
        Path file = baseFolder.resolve(filename);
        try {
            Files.createDirectories(file.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
                writer.write("Hello, World!");
                writer.newLine();
                writer.write("This is the second line.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileLines(String filename) {
        Path file = baseFolder.resolve(filename);

        if (!Files.exists(file) || !Files.isRegularFile(file)) {
            System.err.println("File does not exist.");
            return;
        }

        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            System.out.println("File lines:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileWords(String filename) {
        Path file = baseFolder.resolve(filename);

        if (!Files.exists(file) || !Files.isRegularFile(file)) {
            System.err.println("File does not exist.");
            return;
        }

        try (Scanner scanner = new Scanner(Files.newBufferedReader(file, StandardCharsets.UTF_8))) {
            System.out.println("File words:");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFile(String filename) {
        Path file = baseFolder.resolve(filename);
        try {
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
