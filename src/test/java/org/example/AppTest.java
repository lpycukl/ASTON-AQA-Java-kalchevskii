package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AppTest {

    @Test
    public void testFactorial() {
        assertEquals(App.factorial(0), 1);
        assertEquals(App.factorial(1), 1);
        assertEquals(App.factorial(2), 2);
        assertEquals(App.factorial(3), 6);
        assertEquals(App.factorial(4), 24);
        assertEquals(App.factorial(5), 120);
    }
}