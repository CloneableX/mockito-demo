package com.clo.mockito.simple;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

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

    @Test
    public void stubMultipleResult() {
        when(mockedList.get(anyInt())).thenReturn("first get").thenReturn("more than once get");

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));

        when(mockedList.remove(anyInt())).thenReturn("first remove", "twice remove", "more than twice remove");

        System.out.println(mockedList.remove(0));
        System.out.println(mockedList.remove(0));
        System.out.println(mockedList.remove(0));
        System.out.println(mockedList.remove(0));
    }

    @Test
    public void stubCallback() {
        when(mockedList.set(anyInt(), any())).thenAnswer(new Answer<Object>() {
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                Object mocked = invocationOnMock.getMock();
                return "arguments are: " + args;
            }
        });

        System.out.println(mockedList.set(1, "Answer callback"));
    }
}
