package A4.Google_form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResponsFormHelper extends HelperBase{
	
	WebDriver driver;
	
	By responseFormTitlelLocator = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]");
	By responseFormResultTileLocator = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[2]");
	By responseFormRepeatLocator = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[3]/a");
	
	public ResponsFormHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getResponseFormTitle() {
		String title = "";
		if(IsElementPresent(responseFormTitlelLocator)) {
			title = driver.findElement(responseFormTitlelLocator).getText();
		}
		return title;
	}
	
	public String getResultTitle() {
		String title = "";
		if(IsElementPresent(responseFormResultTileLocator)) {
			title = driver.findElement(responseFormResultTileLocator).getText();
		}
		return title;
	}
	
	public void sendAnotherRequest() {
		if(IsElementPresent(responseFormRepeatLocator)) {
			driver.findElement(responseFormRepeatLocator).click();
		}
	}

}
