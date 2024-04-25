package com.selenium.AutomationGuru99;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.Runner;
import org.openqa.selenium.NoAlertPresentException;

import Runner.TestRunner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     * @throws NoAlertPresentException 
     */
    @Test
    public void shouldAnswerWithTrue() throws NoAlertPresentException, InterruptedException
    {
        assertTrue( true );
        System.out.println("Running the Test");
        TestRunner.FirstTestCase();
        
    }
}
