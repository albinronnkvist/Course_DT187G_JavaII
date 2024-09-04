package com.albinronnkvist.basics.datatypes;

public class Primitive {
    // ******
    // byte *     
    // ******
    public byte byteType = 1;
    public byte byteTypeDefault; // Default: 0
    public byte byteTypeMin = -128, byteTypeMax = 127; // Range: -128 to 127

    // *******
    // short *     
    // *******
    public short shortType = 1;
    public short shortTypeDefault; // Default: 0
    public short shortTypeMin = -32768, shortTypeMax = 32767;

    // *****
    // int *     
    // *****
    public int intType = 1;
    public int intTypeDefault; // Default: 0
    public int intTypeMin = -2_147_483_648, intTypeMax = 2_147_483_647;

    // ******
    // long *     
    // ******
    public long longType = 1L;
    public long longTypeDefault; // Default: 0L
    public long longTypeMin = -9_223_372_036_854_775_808L, longTypeMax = 9_223_372_036_854_775_807L;

    // *******
    // float *     
    // *******
    public float floatType = 1F;
    public float floatTypeDefault; // Default: 0.0F
    public float floatTypeMin = 1.4e-45F, floatTypeMax = 3.4028235e38F;

    // ********
    // double *     
    // ********
    public double doubleType = 1D;
    public double doubleTypeDefault; // Default: 0.0D
    public double doubleTypeMin = 4.9e-324D, doubleTypeMax = 1.7976931348623157e308D;

    // *******
    // char *     
    // *******
    public char charType = 'A';
    public char charTypeDefault; // Default: '\\u0000' (null character)
    public char charTypeMin = '\u0000', charTypeMax = '\uFFFF'; // Range: \\u0000 to \\uffff (0 to 65,535), representing a single Unicode character

    // *******
    // boolean *     
    // *******
    public boolean booleanType = true; // Values: true or false
    public boolean booleanTypeDefault; // Default: false
}
