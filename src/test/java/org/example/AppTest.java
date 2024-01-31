package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void factorial() {
        assertEquals(1,App.factorial(0));
        assertEquals(1,App.factorial(1));
        assertEquals(2,App.factorial(2));
        assertEquals(6,App.factorial(3));
        assertEquals(24,App.factorial(4));
        assertEquals(120,App.factorial(5));
    }
}