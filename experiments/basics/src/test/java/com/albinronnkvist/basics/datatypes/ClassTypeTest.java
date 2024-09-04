package com.albinronnkvist.basics.datatypes;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ClassTypeTest {

    @Test
    public void testDefaultConstructor() {
        var classType = new ClassType();

        assertThat(classType.name).isNull();
        assertThat(classType.age).isEqualTo(0);
        assertThat(classType.address).isNull();
    }

    @Test
    public void testParameterizedConstructor() {
        var classType = new ClassType("Alice", 30, "123 Main St", 12345);

        assertThat(classType.name).isEqualTo("Alice");
        assertThat(classType.age).isEqualTo(30);
        assertThat(classType.address).isNotNull();
        assertThat(classType.address.street).isEqualTo("123 Main St");
        assertThat(classType.address.zipCode).isEqualTo(12345);
    }

    @Test
    public void testInstanceMethodDisplayNameAndAge() {
        var classType = new ClassType("Bob", 25, "456 Elm St", 54321);
        
        assertThat(classType.name).isEqualTo("Bob");
        assertThat(classType.age).isEqualTo(25);
    }

    @Test
    public void testInstanceMethodDisplayAddress() {
        var classType = new ClassType("Charlie", 40, "789 Oak St", 98765);

        assertThat(classType.address.street).isEqualTo("789 Oak St");
        assertThat(classType.address.zipCode).isEqualTo(98765);
    }
    
    @Test
    public void testStaticVariable() {
        assertThat(ClassType.staticName).isEqualTo("John");

        ClassType.staticName = "Jane";
        assertThat(ClassType.staticName).isEqualTo("Jane");
    }

    @Test
    public void testStaticMethodDisplay() {
        assertThat(ClassType.staticMethodGetName()).isEqualTo("John");

        ClassType.staticName = "Doe";
        assertThat(ClassType.staticMethodGetName()).isEqualTo("Doe");
    }
}

