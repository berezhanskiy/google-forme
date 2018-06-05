package A4.Google_form;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  
	protected static WebDriver driver;
	protected GoogleFormHelper formManager;
	protected ResponsFormHelper responseFormManager;
	protected String baseUrl = "https://goo.gl/forms/t16Uov7ZHXCrB2ZE2";
	
	@BeforeMethod
	public void setUpMethod() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
       
		formManager = new GoogleFormHelper (driver);
        responseFormManager = new ResponsFormHelper(driver);
	}
	
	@AfterMethod
	public void beforeMethod() {
		try {
				driver.navigate().refresh();
				driver.switchTo().alert().accept();
		   }
		catch (NoAlertPresentException e) {
			System.out.println("Exception occurred");
		}
		
		driver.close();
	}
	
}
