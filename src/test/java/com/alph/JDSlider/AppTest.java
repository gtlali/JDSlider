package com.alph.JDSlider;

import java.io.IOException;
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
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);

	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException 
	 */
	public void testApp() throws InterruptedException  {
		
		DesktopOptions option = new DesktopOptions();

		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		WiniumDriver driver=null;
		try {
			driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.name("6")).click();
		driver.findElement(By.id("92")).click();
		driver.findElement(By.name("8")).click();
		driver.findElement(By.name("Equals")).click();
		String output = driver.findElement(By.id("150")).getAttribute("Name");
		
		System.out.println("Result after addition is:"+output);
		
		driver.findElement(By.id("81")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("136")).click();
		driver.findElement(By.id("134")).click();
		//driver.findElement(By.name("6")).click();
		driver.findElement(By.id("91")).click();
		driver.findElement(By.name("2")).click();
		driver.findElement(By.name("Equals")).click();
		output = driver.findElement(By.id("150")).getAttribute("Name");
		System.out.println("Result after addition is:"+output);
		
		driver.findElement(By.id("81")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("134")).click();
		driver.findElement(By.id("135")).click();
		driver.findElement(By.id("104")).click();
		//driver.findElement(By.name("2")).click();
		driver.findElement(By.name("Equals")).click();
		output = driver.findElement(By.id("150")).getAttribute("Name");
		System.out.println("Result after addition is:"+output);
		driver.quit();

	    assertTrue( true );
	}
}
