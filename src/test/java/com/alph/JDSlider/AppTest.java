package com.alph.JDSlider;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.util.Calendar;
//import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
//import org.openqa.selenium.winium.WiniumDriverService;

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
		mytestCalc(option,driver);
		//startJDSlider();	
		
		assertTrue( true );
	}
	
	public void mytestCalc(DesktopOptions option, WiniumDriver driver) throws InterruptedException
	{
		
		try {
			driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Thread.sleep(3000);		

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
		captureScreen(driver);
		driver.findElement(By.name("Close")).click();		
		System.out.println("Closed the calculator app");
			
		
	}
	public String captureScreen(WiniumDriver augmentedDriver ) {
	    String path;
	    try {
	    	File source = augmentedDriver.getScreenshotAs(OutputType.FILE);	       
	        path = "D:/target/screenshots/" + source.getName();
	        FileUtils.copyFile(source, new File(path)); 
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    
	    return path;
	}
	public void startJDSlider() //DesktopOptions opt, WiniumDriver augmentedDriver
	{
		DesktopOptions opt = new DesktopOptions();
		opt.setApplicationPath("D:\\gtlali\\github\\git\\JDSlider\\target\\JDSlider-0.0.1-SNAPSHOT.jar");
		WiniumDriver d=null;
		try {
			d = new WiniumDriver(new URL("http://localhost:9999"), opt);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		d.findElement(By.id("TitleBar")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.findElement(By.name("Close")).click();			
		d.quit();
	}
	
	
}
