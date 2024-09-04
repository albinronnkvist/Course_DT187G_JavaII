package com.albinronnkvist.basics.datatypes;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimitiveTests {
    private Primitive primitive;

    @BeforeEach
    public void setUp() {
        primitive = new Primitive();
    }

    @Test
    public void testByteType() {
        assertThat(primitive.byteType).isEqualTo((byte) 1);
        assertThat(primitive.byteTypeDefault).isEqualTo((byte) 0);
        assertThat(primitive.byteTypeMin).isEqualTo((byte) Byte.MIN_VALUE);
        assertThat(primitive.byteTypeMax).isEqualTo((byte) Byte.MAX_VALUE);
    }

    @Test
    public void testShortType() {
        assertThat(primitive.shortType).isEqualTo((short) 1);
        assertThat(primitive.shortTypeDefault).isEqualTo((short) 0);
        assertThat(primitive.shortTypeMin).isEqualTo((short) Short.MIN_VALUE);
        assertThat(primitive.shortTypeMax).isEqualTo((short) Short.MAX_VALUE);
    }

    @Test
    public void testIntType() {
        assertThat(primitive.intType).isEqualTo(1);
        assertThat(primitive.intTypeDefault).isEqualTo(0);
        assertThat(primitive.intTypeMin).isEqualTo(Integer.MIN_VALUE);
        assertThat(primitive.intTypeMax).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void testLongType() {
        assertThat(primitive.longType).isEqualTo(1L);
        assertThat(primitive.longTypeDefault).isEqualTo(0L);
        assertThat(primitive.longTypeMin).isEqualTo(Long.MIN_VALUE);
        assertThat(primitive.longTypeMax).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    public void testFloatType() {
        assertThat(primitive.floatType).isEqualTo(1F);
        assertThat(primitive.floatTypeDefault).isEqualTo(0.0F);
        assertThat(primitive.floatTypeMin).isEqualTo(Float.MIN_VALUE);
        assertThat(primitive.floatTypeMax).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    public void testDoubleType() {
        assertThat(primitive.doubleType).isEqualTo(1D);
        assertThat(primitive.doubleTypeDefault).isEqualTo(0.0D);
        assertThat(primitive.doubleTypeMin).isEqualTo(Double.MIN_VALUE);
        assertThat(primitive.doubleTypeMax).isEqualTo(Double.MAX_VALUE);
    }

    @Test
    public void testCharType() {
        assertThat(primitive.charType).isEqualTo('A');
        assertThat(primitive.charTypeDefault).isEqualTo('\u0000');
        assertThat(primitive.charTypeMin).isEqualTo('\u0000');
        assertThat(primitive.charTypeMax).isEqualTo('\uFFFF');
    }

    @Test
    public void testBooleanType() {
        assertThat(primitive.booleanType).isTrue();
        assertThat(primitive.booleanTypeDefault).isFalse();
    }
}