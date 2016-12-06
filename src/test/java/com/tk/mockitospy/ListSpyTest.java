package com.tk.mockitospy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doReturn;

public class ListSpyTest {

    @Spy
    List<String> myList = new ArrayList<String>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        myList.add("Jonny");
        myList.add("Camilla");

        doReturn(2).when(myList).size();
        int result = myList.size();
        assertSame(2, result);
    }
}
