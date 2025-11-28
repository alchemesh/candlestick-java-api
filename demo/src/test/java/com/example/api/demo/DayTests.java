package com.example.api.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


class DayTests {

    private static Day day;

    @BeforeAll
    static void setUpTests() {
        // This method runs once before all tests in this class
        day = new Day();
    }

	@Test
    void testState() {
        day.setState("Bearish");
        String expected = "Bearish";
        String actual = day.getState();
        assertEquals(expected, actual, "Get should be 'Bearish'");
    }

    @Test
    void testDate() {
        day.setDate("2025-11-28");
        String expected = "2025-11-28";
        String actual = day.getDate();
        assertEquals(expected, actual, "Get should be '2025-11-28'");
    }

    @Test
    void testOpen() {
        day.setOpen(248.35);
        Double expected = 248.35;
        Double actual = day.getOpen();
        assertEquals(expected, actual, "Get should equal '248.35'");
    }

    @AfterAll
    static void tearDownTests() {
        // This method runs once after all tests in this class
        day = null;
        
    }

}