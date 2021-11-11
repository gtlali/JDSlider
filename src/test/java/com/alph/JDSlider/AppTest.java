package com.alph.JDSlider;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.util.Calendar;
//import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
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
		try {
			mytestCalc(option,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//startJDSlider();	
		
		assertTrue( true );
	}
	
	public void mytestCalc(DesktopOptions option, WiniumDriver driver) throws InterruptedException, IOException
	{
		
		try {
			driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Thread.sleep(2000);		

		driver.findElement(By.name("6")).click();
		driver.findElement(By.id("92")).click();
		driver.findElement(By.name("8")).click();
		driver.findElement(By.name("Equals")).click();
		String output = driver.findElement(By.id("150")).getAttribute("Name");
		
		System.out.println("Result after Multiplication is:"+output);
		
		driver.findElement(By.id("81")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("136")).click();
		driver.findElement(By.id("134")).click();
		//driver.findElement(By.name("6")).click();
		driver.findElement(By.id("91")).click();
		driver.findElement(By.name("2")).click();
		driver.findElement(By.name("Equals")).click();
		output = driver.findElement(By.id("150")).getAttribute("Name");
		String cls = driver.findElement(By.id("150")).getClass().getName();
		String css = driver.findElement(By.id("150")).getCssValue("Name");
		
		System.out.println("Result after Division is:"+output+"::"+cls +"::"+css);
		
		driver.findElement(By.id("81")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("134")).click();
		driver.findElement(By.id("135")).click();
		driver.findElement(By.id("104")).click();
		//driver.findElement(By.name("2")).click();
		driver.findElement(By.name("Equals")).click();
		output = driver.findElement(By.id("150")).getAttribute("Name");
		System.out.println("Class name:" + driver.findElement(By.id("150")).getAttribute("Name").getClass());
		System.out.println("Result after trignometric function tan@ is:"+output);		
		System.out.println("Screenshot path:"+ captureFullScreenShot(driver));
		
		takeScreenshotActiveTestWindow(driver);
		takeScreenshotElement(driver);
		driver.findElement(By.name("Close")).click();		
		System.out.println("Closed the calculator app");
			
		
	}
	public String captureFullScreenShot(WiniumDriver augmentedDriver ) {
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
	
	
	public void takeScreenshotActiveTestWindow(WiniumDriver winiDriver ) throws IOException {
		WebElement element = winiDriver.findElement(By.name("Calculator"));	
	    File screenshot = winiDriver.getScreenshotAs(OutputType.FILE);
	    Rectangle rectangle = new Rectangle(element.getSize().width, element.getSize().height);
	    System.out.println("Element size" + rectangle + "::"+ element.getAttribute("BoundingRectangle"));
	    
	    String[] values = element.getAttribute("BoundingRectangle").split(",");	    
	    System.out.println("value of values:" + values[0]);
	    int x = Integer.parseInt(values[0]);
	    int y = Integer.parseInt(values[1]);
	    BufferedImage bufferedImage = ImageIO.read(screenshot);
	    BufferedImage destImage = bufferedImage.getSubimage(x+7, y, rectangle.width-14, rectangle.height-7);
	    ImageIO.write(destImage, "png", screenshot);
	    String path = "D:/target/screenshots/" + screenshot.getName();
	 
	    FileUtils.copyFile(screenshot, new File(path));   	   
    
	}
	
	public void takeScreenshotElement(WiniumDriver winiDriver ) throws IOException {
		WebElement element = winiDriver.findElement(By.id("105"));	
	    File screenshotElement = winiDriver.getScreenshotAs(OutputType.FILE);
	    Rectangle rectangle = new Rectangle(element.getSize().width, element.getSize().height);
	    System.out.println("Element size" + rectangle + "::"+ element.getAttribute("BoundingRectangle"));
	    
	    String[] values = element.getAttribute("BoundingRectangle").split(",");	    
	    System.out.println("value of values:" + values[0]);
	    int x = Integer.parseInt(values[0]);
	    int y = Integer.parseInt(values[1]);
	    BufferedImage bufferedImage = ImageIO.read(screenshotElement);
	    BufferedImage destImage = bufferedImage.getSubimage(x+5, y, rectangle.width-10, rectangle.height-5);
	    ImageIO.write(destImage, "png", screenshotElement);
	    String path = "D:/target/screenshots/" + screenshotElement.getName();
	 
	    FileUtils.copyFile(screenshotElement, new File(path));   	   
    
	}
	
	
}
