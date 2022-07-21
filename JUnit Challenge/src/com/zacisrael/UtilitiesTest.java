package com.zacisrael;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities util;

    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }
    @org.junit.Test
    public void everyNthChar() throws Exception{

        char[] output = new char[]{'h', 'e','l', 'l', 'o'};
        assertArrayEquals(new char[]{'e', 'l'}, util.everyNthChar(output,2));

        char[] output2 = util.everyNthChar(new char[]{'h', 'e','l', 'l', 'o',}, 8);
        assertArrayEquals(new char[]{'h', 'e','l', 'l', 'o'}, output2);
    }

    @org.junit.Test
    public void removePairs() throws Exception {

        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEFF"));
        assertEquals("ABZCFIUTUYUY", util.removePairs("AAAAAAAAABZCFFFIIUTUYYUY"));
        assertNull("Did not get null returned.", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));


    }

    @org.junit.Test
    public void convert() throws Exception{

        assertEquals(300, util.convert(10,5));

    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter() throws Exception{

        util.convert(10, 0);

    }

    @org.junit.Test
    public void nullIfOddLength() throws Exception{
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}