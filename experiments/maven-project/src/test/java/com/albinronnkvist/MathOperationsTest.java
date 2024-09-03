package com.albinronnkvist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

public class MathOperationsTest {

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",      // Test with positive numbers
        "-1, 1, 0",     // Test with a positive and a negative number
        "-1, -1, -2",   // Test with two negative numbers
        "0, 0, 0"       // Test with zeros
    })
    public void testAddNumbers(int a, int b, int sum) {
        var result = MathOperations.addNumbers(a, b);
        assertThat(result).isEqualTo(sum);
    }
}
