package com.tk.mockitospy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

public class ListMockSpyTest {

    @Mock
    List<String> myList = new ArrayList<String>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {

        when(myList.size()).thenReturn(2);
        when(myList.size()).thenCallRealMethod();
        int result = myList.size();

        assertSame(2, result);
    }



}
