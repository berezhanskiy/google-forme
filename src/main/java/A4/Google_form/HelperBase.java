package A4.Google_form;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
	
	protected WebDriver driver;

	public HelperBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean IsElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException exception)
        {
            return false;
        }
    }
	
	public void Type(By locator, String text)
    {
        if (text != null)
        {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

}
