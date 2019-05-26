package com.clo.mockito.simple;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * com.clo.mockito.simple.StubDemo
 *
 * @author Cloneable
 * @date 2019/5/26 16:08:26
 * @description
 */
public class StubDemo {
    @Test
    public void stubWithArgMatcher() {
        ArrayList mock = mock(ArrayList.class);

        when(mock.get(anyInt())).thenReturn("mock get method");

        System.out.println(mock.get((int)(Math.random() * 10)));
    }

    @Mock
    private List mockedList;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void stubVoidMethod() {
        doNothing().when(mockedList).add(anyInt(), any());
        doThrow(new RuntimeException("throw runtime exception")).when(mockedList).clear();

        mockedList.add(0, "123");
        mockedList.clear();
    }
}
