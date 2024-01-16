package com.booleanuk.core;

import com.booleanuk.StudentSelector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoreTest {

    @Test
    public void testRun() {
        StudentSelector s = new StudentSelector();
        Assertions.assertTrue(s.run());
    }

    @Test
    public void testShowMenu() {
        StudentSelector s = new StudentSelector();
        Assertions.assertTrue(s.showMenu());
    }

    @Test
    public void testInstantiateListFromFile() {
        StudentSelector s = new StudentSelector();
        Assertions.assertTrue(s.students.contains("Nicolai Klokmose"));
        Assertions.assertFalse(s.students.contains("Dennis Bergkamp"));
    }

    @Test
    public void testOptionA() {
        StudentSelector s = new StudentSelector();
        Assertions.assertTrue(s.students.contains(s.optionA()));
        Assertions.assertFalse(!s.students.contains(s.optionA()));

        Assertions.assertEquals("Dave Amos", s.optionA());
        Assertions.assertNotEquals("Nicolai Klokmose", s.optionA());
    }

    @Test
    public void testOptionB() {
        StudentSelector s = new StudentSelector();
        Assertions.assertTrue(s.students.contains(s.optionB()));
        Assertions.assertFalse(!s.students.contains(s.optionB()));

        Assertions.assertEquals(new String[0], s.optionB());
    }

}
