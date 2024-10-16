package com.albinronnkvist.basics;

import com.albinronnkvist.basics.fileHandling.FileHandler;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.CreateFileWithBufferedWriter("test.txt");
        fileHandler.ReadFileLines("test.txt");
        fileHandler.ReadFileWords("test.txt");
    }
}