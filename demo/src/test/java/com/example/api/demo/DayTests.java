package com.example.api.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DayTests {

    private static Day day;

    @BeforeAll
    static void setUpTests() {
        // This method runs once before all tests in this class
        this.day = new Day();
    }

	@Test
    void testState() {
        this.day.setState("Bearish");
        String expected = "Bearish";
        String actual = this.day.getState();
        assertEquals(expected, actual, "Get should be 'Bearish'");
    }

    @AfterAll
    static void tearDownTests() {
        // This method runs once after all tests in this class
        this.day = null;
        
    }

}