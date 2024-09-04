package com.albinronnkvist.basics.other;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StaticClassTests {
    @Test
    public void testStaticMethodAddition() {
        final int a = 5;
        final int b = 10;

        int result = StaticClass.staticMethodAddition(a, b);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void testStaticMethodAdditionWithNegativeNumbers() {
        final int a = -5;
        final int b = -10;

        int result = StaticClass.staticMethodAddition(a, b);

        assertThat(result).isEqualTo(-15);
    }

    @Test
    public void testStaticMethodAdditionWithMixedNumbers() {
        final int a = 5;
        final int b = -10;

        int result = StaticClass.staticMethodAddition(a, b);

        assertThat(result).isEqualTo(-5);
    }

    @Test
    public void testStaticMethodAdditionWithZero() {
        final int a = 0;
        final int b = 10;

        int result = StaticClass.staticMethodAddition(a, b);

        assertThat(result).isEqualTo(10);
    }
}
