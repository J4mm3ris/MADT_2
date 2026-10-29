package com.custom.madt_2;

import org.junit.Test;

import static org.junit.Assert.*;

public class logic_tests {

    @Test
    public void test_Empty() {
        for (int pos = 0; pos <= 3; pos++) {
            assertEquals(-1, MainActivity.count(pos, ""));
        }
    }

    @Test
    public void test_Sentences() {
        assertEquals(3, MainActivity.count(0, "Hello! My name is John. Do you like apples?"));
    }

    @Test
    public void test_Words() {
        assertEquals(9, MainActivity.count(1, "Hello! My name is John. Do you like apples?"));
    }

    @Test
    public void test_Chars() {
        assertEquals(43, MainActivity.count(2, "Hello! My name is John. Do you like apples?"));
    }

    @Test
    public void test_Numbers() {
        assertEquals(6, MainActivity.count(3, "Hello! My username is John123. I have 1 apple and 12 bananas."));
    }
}