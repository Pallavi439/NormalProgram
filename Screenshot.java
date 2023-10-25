import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Screenshot {
	@Test
	public void screenshot() throws IOException
	{
		ChromeDriver d=new ChromeDriver();
		d.get("https://www.google.com/");
		d.manage().window().maximize();
		WebElement search=d.findElement(By.id("APjFqb"));
		
		search.sendKeys("India");
		search.sendKeys(Keys.ENTER);
		TakesScreenshot ts=((TakesScreenshot)d);
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("E:\\Pallavi-WorkingDirectory\\Assignments\\src\\screenshot\\pass"+Math.random()+".png");
		FileUtils.copyFile(SrcFile, destFile);
		
	}
	@Test(timeOut=1000)
	public void failscreenshot() throws IOException
	{
		ChromeDriver d=new ChromeDriver();
		System.out.println("1");
		d.get("https://www.google.com/");
		d.manage().window().maximize();
		WebElement search=d.findElement(By.id("APjFqba"));
		
		search.sendKeys("India");
		
		search.sendKeys(Keys.ENTER);
		System.out.println("2");
		TakesScreenshot ts=((TakesScreenshot)d);
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("E:\\Pallavi-WorkingDirectory\\Assignments\\src\\screenshot\\fail3"+Math.random()+".png");
		System.out.println("3");
		FileUtils.copyFile(SrcFile, destFile);
		d.quit();
		
	}
}
