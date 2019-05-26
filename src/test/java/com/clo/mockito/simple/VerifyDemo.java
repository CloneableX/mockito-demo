package com.clo.mockito.simple;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * com.clo.mockito.simple.VerifyDemo
 *
 * @author Cloneable
 * @date 2019/5/26 16:32:26
 * @description
 */
public class VerifyDemo {
    @Mock
    private List mockedList;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyExtraNum() {
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, never()).add("never happen");

        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(2)).add("twice");
    }
}
