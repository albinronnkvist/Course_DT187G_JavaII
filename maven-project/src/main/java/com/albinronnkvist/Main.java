package com.albinronnkvist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        var num1 = scanner.nextInt();
        
        System.out.print("Enter the second number: ");
        var num2 = scanner.nextInt();
        
        var sum = MathOperations.addNumbers(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
        
        scanner.close();
    }
}