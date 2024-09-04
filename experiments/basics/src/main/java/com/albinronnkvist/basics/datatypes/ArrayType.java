package com.albinronnkvist.basics.datatypes;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayType {
    // ##################
    // Declaration and Initialization

    // Declare and initialize in one line
    // Array of 5 integers, default values are 0
    public int[] numbersDefaultFixedSize = new int[5];

    // Declare and initialize with values
    // Array with 5 elements initialized with values
    public int[] numbersWithValues = {1, 2, 3, 4, 5}; 

    // Declare an array of strings
    public String[] names = {"Alice", "Bob", "Charlie"};


    // ##################
    // Accessing Elements
    public void accessElements() {
        // Accessing elements using index
        var firstNumber = numbersWithValues[0]; // Accesses the first element (index 0)
        System.out.println("First number: " + firstNumber); // Output: 1
    
        // Modifying an element
        System.out.println("Initial second number: " + numbersWithValues[1]); // Output: 2
        numbersWithValues[1] = 10; // Changes the second element to 10
        System.out.println("Modified second number: " + numbersWithValues[1]); // Output: 10
    
        // Accessing a string array
        var firstName = names[0]; // "Alice"
        System.out.println("First name: " + firstName);

        // Modifying a string array
        System.out.println("Initial second name: " + names[1]);
        names[1] = "David"; // Changes "Bob" to "David"
        System.out.println("Modified second name: " + names[1]);
    }


    // ##################
    // Iterating Over Arrays
    public void iterateOverArray() {
        for (var number : numbersWithValues) {
            System.out.println(number);
        }
    }


    // ##################
    // Copy arrays
    public int[] copyArrays() {
        int[] original = {1, 2, 3, 4, 5};
        var copy = new int[original.length];

        System.arraycopy(original, 0, copy, 0, original.length);

        return copy;
    }

    // ##################
    // Copy arrays
    public int[] copyArraysCopyOf() {
        int[] original = {1, 2, 3, 4, 5};
        var copy = Arrays.copyOf(original, original.length);

        return copy;
    }

    // ##################
    // Sorting arrays
    public void sortArray() {
        int[] numbers = {5, 3, 8, 1, 2};

        Arrays.sort(numbers); // Sorts the array in ascending order

        // Output sorted array
        for (int number : numbers) {
            System.out.println(number);
        }
    }


    // ##################
    // Multi-Dimensional Arrays
    public void multiDimensionalArrays() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    // ##################
    // ArrayList (Dynamic Arrays)
    public void arrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");

        // Accessing elements
        String name = list.get(0); // "Alice"
        System.out.println(name);

        // Modifying elements
        list.set(1, "Charlie");

        // Removing elements
        list.remove("Alice");

        // Iterating
        for (String n : list) {
            System.out.println(n);
        }
    }
}
