import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Googlelinks {
	
	@Test
	public void test() throws IOException
	{
	ChromeDriver d=new ChromeDriver();
	d.get("https://www.amazon.in/");
	d.manage().window().maximize();
	//WebElement search=d.findElement(By.id("APjFqb"));
	
	List <WebElement> links=d.findElements(By.tagName("a"));
	int count=links.size();
	System.out.println(count);
	for(int i=0;i<count;i++)
	{
		WebElement w1=links.get(i);
		String url=w1.getAttribute("href");
		//System.out.println("url");
		verifybrokenlinks(url);
		
	}

}
	public static void verifybrokenlinks(String url) throws IOException, NullPointerException
	{
		try
		{
		URL ul=new URL(url);
		HttpURLConnection rv=    (HttpURLConnection) ul.openConnection();
		rv.connect();
		if(rv.getResponseCode()==200)
		{
			System.out.println(url+"vaild link"+rv.getResponseCode());
		}
		else
		{
			System.out.println(url+"invaild link");
		}
		
	}
		catch(NullPointerException a1)
		{
			System.out.println("valid link"+a1);
		}
		catch(MalformedURLException a2)
		{
			System.out.println("valid link"+a2);
		}
	}
	
}
