package com.clo.mockito.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * com.clo.mockito.simple.SimpleDemo
 *
 * @author Cloneable
 * @date 2019/5/5 21:54:05
 * @description
 */
public class SimpleDemo {
    @Test
    public void simpleVerifyTest() {
        // create a mock of List
        List mockList = mock(List.class);

        // call add and clear method of mocked List
        mockList.add("123");
        mockList.clear();

        // verify interaction of mocked List
        verify(mockList).add("123");
        verify(mockList).clear();
    }

    @Test
    public void simpleStubbingTest() {
        // create a mock of ArrayList
        ArrayList mockList = mock(ArrayList.class);

        // stubbing
        when(mockList.get(0)).thenReturn("first element");
        when(mockList.get(1)).thenThrow(new RuntimeException("mockList.get(1)"));

        // prints "first element"
        System.out.println(mockList.get(0));

        // throws RuntimeException
        System.out.println(mockList.get(1));

        // prints null
        System.out.println(mockList.get(999));

        verify(mockList).get(0);
    }
}
