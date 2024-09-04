package com.albinronnkvist.basics.other;

/*
In Java, there is no direct equivalent to C#'s static class. 
However, you can achieve similar functionality by combining a few techniques. 
The goal is to create a class that cannot be instantiated and is intended to hold only static methods and variables.
    Make the Class final:
        Declaring the class as final prevents it from being subclassed. This ensures that the class remains as a utility or static-only class without any inheritance.
    Private Constructor:
        A private constructor prevents the instantiation of the class. This is essential for creating a class that cannot have objects.
    Static Methods and Variables:
        Ensure that all methods and variables in the class are static. This allows them to be accessed directly using the class name, without needing an instance of the class.
*/
public final class StaticClass {
    private StaticClass() {
    }

    public static int staticMethodAddition(int a , int b) {
        return a + b;
    }
}
