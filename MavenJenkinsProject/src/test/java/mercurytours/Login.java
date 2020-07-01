package mercurytours;



import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	
	
		public WebDriver driver;
		
	    @BeforeSuite
		public void openBrowser()
		{
			System.out.println("under before suite");
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	    
	    @BeforeTest
	    public void passURL()
	    {
	    	System.out.println("under before test");
	    	driver.get("http://newtours.demoaut.com/");
	    }
	    
	    @BeforeClass
	    public void maximizeWindow()
	    {
	    	System.out.println("under before class");
	    	driver.manage().window().maximize();
	    }
	    
	    @BeforeMethod
	    public void getCookies()
	    {
	    	System.out.println("under before method");
	    	Set <Cookie> cookies= driver.manage().getCookies();
	    	for (Cookie cookie : cookies) 
	    	{
				System.out.println("cookies name--"+cookie.getName());
			}
	    }
	    
	    @Test(dataProvider= "getData")
	    public void loginWithValidUser(String username, String password)
	    {
	    	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    	driver.findElement(By.xpath("//input[@name='login']")).click();
	    	
	    }
	    
	    @AfterMethod
	    public void captureScreenshot()
	    {
	    	System.out.println("under after method");
	    	/*File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(src, new File ("C:\\Users\\Hp\\Desktop\\Screenshot\\mercury tours.jpeg"));
	    	*/
	    }
	    
	    @AfterClass
	    public void deleteCookies()
	    {
	    	System.out.println("under after class");
	    	driver.manage().deleteAllCookies();
	    }
	    
	    @AfterTest
	    public void dbConnectionClose()
	    {
	    	System.out.println("under after test");
	    }
	    
	    @AfterSuite
	    public void closeBrowser()
	    {
	    	System.out.println("under after suite");
	    	driver.quit();
	    }
	    
	    @DataProvider
	    public Object[][] getData()
	    {
	    	return new Object[][] 
	    	{
	    		new Object[] {"choudharianurag05@gmail.com", "Anurag05"},
	    			};
	    }

}
