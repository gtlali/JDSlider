package com.alph.JDSlider;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws MalformedURLException 
     */
    public void testApp() throws MalformedURLException {
    	DesktopOptions options = new DesktopOptions();
    	options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
    	
    	WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options); 	
    	driver.findElement(By.name("6")).click();
    	driver.findElement(By.id("92")).click();
    	driver.findElement(By.name("8")).click();
    	driver.findElement(By.name("Equals")).click();
    	String s = driver.findElement(By.id("150")).getAttribute("Name");
    	if (s.equals("48"))
    		assertTrue( true );
    	else
    		assertFalse(true);
    	
    	
    
       //assertTrue( true );
    }
}
