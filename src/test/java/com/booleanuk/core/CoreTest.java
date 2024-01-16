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

}
