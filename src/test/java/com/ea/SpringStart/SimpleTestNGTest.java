package com.ea.SpringStart;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTestNGTest {

    @Test
    public void shouldRunSimpleAssertion() {
        Assert.assertTrue(true, "Simple assertion should pass");
    }
}


