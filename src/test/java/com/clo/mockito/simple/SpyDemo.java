package com.clo.mockito.simple;

import static org.mockito.Mockito.*;
import org.junit.Test;

import java.util.ArrayList;

/**
 * com.clo.mockito.simple.SpyDemo
 *
 * @author Cloneable
 * @date 2019/6/2 17:08:02
 * @description demo of spying
 */
public class SpyDemo {
    @Test
    public void spyObject() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList spyList = spy(arrayList);

        doReturn(100).when(spyList).size();

        System.out.println(spyList.size());

        spyList.add(0);
        spyList.add(1);

        System.out.println(spyList.size());
        System.out.println(spyList.toString());

        verify(spyList).add(0);
        verify(spyList).add(1);
    }
}
