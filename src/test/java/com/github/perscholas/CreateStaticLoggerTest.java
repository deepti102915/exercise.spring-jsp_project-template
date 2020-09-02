package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateStaticLoggerTest {
    private static Logger logger = Logger.getLogger(CreateStaticLoggerTest.class.getName());
    @Test
    public void testRun() { // TODO
        // Given

        // when
        logger.log(Level.INFO, "Hey check out the information I'm logging!");

        //then
    }
}
