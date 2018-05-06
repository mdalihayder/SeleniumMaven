//Selenium (Eclipse> Maven> Git> Jenkins)
package JPay;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase {

	WebDriver driver;
	
	  @Parameters("browser")

	  @BeforeClass

	  // Passing Browser parameter from TestNG xml File.

	  public void beforeTest(String browser) {

	  // If the browser is ie, then do this

	  if(browser.equalsIgnoreCase("ie")) {
		  
		  System.setProperty("webdriver.ie.driver","C:\\Users\\M\\Desktop\\SeleniumJars\\IEDriverServer.exe");

		  driver = new InternetExplorerDriver();

	  // If browser is chrome, then do this	  

	  }else if (browser.equalsIgnoreCase("chrome")) { 

	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\M\\Desktop\\SeleniumJars\\chromedriver.exe");
	    	driver = new ChromeDriver();

	  }else if (browser.equalsIgnoreCase("firefox")) { 

	    	System.setProperty("webdriver.gecko.driver","C:\\Users\\M\\Desktop\\SeleniumJars\\geckodriver.exe");
	    	driver = new FirefoxDriver();

	  } 

	  // Doesn't the browser type, lauch the Website
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.jpay.com");
	  driver.manage().window().maximize();
	  }	

     @Test
    public void TestCase1() {
        
        driver.findElement(By.xpath("//*[@id=\"newHeader_TopRightNavButton_lnkLogin\"]/div")).click(); 
        driver.findElement(By.xpath("//*[@id=\"uclLoginFirstTime_txtUserId\"]")).sendKeys("ahayder@jpay.com");  
        driver.findElement(By.xpath("//*[@id=\"uclLoginFirstTime_txtPassword\"]")).sendKeys("password"); 
        driver.findElement(By.xpath("//*[@id=\"uclLoginFirstTime_btnContinue\"]/div")).click(); 
        driver.findElement(By.xpath("//*[@id=\"myheader_TopRightNavButton_lnkLogout\"]/div")).click();
    }
    
    @AfterClass
    public void afterClass() throws InterruptedException {
    	Thread.sleep(5000);
        driver.quit();
    }
}