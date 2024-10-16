package com.albinronnkvist.basics;

import com.albinronnkvist.basics.fileHandling.NioFileHandler;

public class Main {
    public static void main(String[] args) {
        NioFileHandler fileHandler = new NioFileHandler();
        fileHandler.createFileWithBufferedWriter("test.txt");

        fileHandler.readFileLines("test.txt");
        fileHandler.readFileWords("test.txt");

        //fileHandler.listFolderContent();
        fileHandler.deleteFile("test.txt");
    }
}