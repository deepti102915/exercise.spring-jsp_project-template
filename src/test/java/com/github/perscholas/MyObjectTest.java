package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 9/3/2020.
 */
public class MyObjectTest {
    @Test
    public void test() {
        // given
        Runnable r = System.out::println;

        // when
        r.run();

        // then
        Assert.assertNotNull(r);
    }
}
