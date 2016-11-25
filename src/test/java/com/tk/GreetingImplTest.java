package com.tk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingImplTest {

    @Test
    public void greetShouldReturnValidOutput()  {
        Greeting greeting = new  GreetingImpl();
        String result = greeting.greet("jUnit");

        assertNotNull(result);
        assertEquals("Hello jUnit", result);

    }
}