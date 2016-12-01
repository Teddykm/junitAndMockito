package com.tk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingImplTest {

    Greeting greeting;

    @Before
    public void setup() {
        greeting = new  GreetingImpl();
    }

    @Test
    public void greetShouldReturnValidOutput()  {
        String result = greeting.greet("jUnit");
        assertNotNull(result);
        assertEquals("Hello jUnit", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnExceptionWhenNameIsNull() {
        greeting.greet(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnExceptionWhenNameIsEmpty() {
        greeting.greet("");
    }
}