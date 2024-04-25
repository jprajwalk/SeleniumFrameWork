package Runner;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestRunner 
{

	public static void FirstTestCase() throws InterruptedException ,NoAlertPresentException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Prajwal\\EclipseWorkSpace\\chromedriver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	  //  options.addArguments("--headless"); // Set headless mode
	  //  options.addArguments("--disable-gpu"); // Disable GPU to prevent potential issues
	    WebDriver driver = new ChromeDriver(options);
		
	        
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Initiating the web page
		driver.get("https://demo.guru99.com/V4/");
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr567415");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("EjebanY");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		// Adding the new account 
		driver.findElement(By.xpath("//div[3]/div/ul/li[2]/a")).click();
		
		// Entering the details of the new customer
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("TestFive");
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).click();
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("02-01-1992");
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys("560001");
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("8813990099");
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("testfive@mail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	
		// Handle success scenario
		System.out.println("Account registration successful.");
        WebElement customerIdElement = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]"));
        String customerId = customerIdElement.getText();
        System.out.println("Customer ID: " + customerId);
        WebElement customerNameElement = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[5]/td[2]"));
        String customerName = customerNameElement.getText();
        System.out.println("Customer Name: " + customerName);

        Thread.sleep(10000);
        //99996
        
        // Delete Account  
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[4]/a")).click();
     
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('.ad-element').forEach(el => el.remove())");

       
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerId);
        driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alertMessageDelete = wait.until(ExpectedConditions.alertIsPresent());
        String deleteAlertMessage = alertMessageDelete.getText();
        System.out.println(deleteAlertMessage);
        
        alertMessageDelete.accept();
        alertMessageDelete.accept();
        
        
        
        
        
        
        
//		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
//		// Accepting the Alert/pop up created at end
//		Alert alert = driver.switchTo().alert();
//		alert.dismiss();		
//		driver.quit();
		
	
		
		
	}
}
