package A4.Google_form;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleFormHelper extends HelperBase {
	
	WebDriver driver;
	
	By formEmailLocator = By.name("emailAddress");
	By formNameLocator = By.name("entry.1375459729");
	By formBday = By.xpath("/html/body/div[1]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/input");
	By formBmonth = By.xpath("/html/body/div[1]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[1]/input");
	By formByear = By.xpath("/html/body/div[1]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/div/div[5]/div/div[2]/div[1]/div/div[1]/input");
	By formGenderPicker = By.name("entry.1375459729");
	By formGenderTitle = By.xpath("/html/body/div[1]/div[2]/form/div/div[2]/div[2]/div[4]/div[2]/div[1]/div[1]/div[1]/content");
	By formHowAreYouBlock = By.xpath("/html/body/div[1]/div[2]/form/div/div[2]/div[2]/div[5]/div[2]");
	By formFildOther = By.xpath("/html/body/div[1]/div[2]/form/div/div[2]/div[2]/div[5]/div[2]/div[6]/div/div/div/div/div/div[1]/input");
	By formSubmitButton = By.xpath("/html/body/div[1]/div[2]/form/div/div[2]/div[3]/div[1]/div/div");
	By formErrorTite = By.className("freebirdFormviewerViewItemsItemErrorMessage");
	
	String formHawAreYouPickPath = "/html/body/div[1]/div[2]/form/div/div[2]/div[2]/div[5]/div[2]/div[1]/div/label/div/div[1]";
	
	WebElement email;
	WebElement name;
	
	public GoogleFormHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void fillEmail(String userEmail) {
		if(IsElementPresent(formEmailLocator)) {
			email = driver.findElement(formEmailLocator);
			email.click();
			email.sendKeys(userEmail);
		}
	}
	
	public void fillName(String userName) {
		if(IsElementPresent(formNameLocator)) {
			name = driver.findElement(formNameLocator);
			name.click();
			name.sendKeys(userName);
		}
	}
	
	public void fillDate(String userBday, String userBmonth, String userByear) {
		fillBday(userBday);
		fillBmonth(userBmonth);
		fillByear(userByear);
	}
	
	public void fillBday(String Bday) {
		if(IsElementPresent(formBday)) {
			driver.findElement(formBday).click();
			driver.findElement(formBday).click();
			driver.findElement(formBday).clear();
			driver.findElement(formBday).sendKeys(Bday);
		}
	}
	
	public void fillBmonth(String userBmonth) {
		if(IsElementPresent(formBmonth)) {
			driver.findElement(formBmonth).click();
			driver.findElement(formBmonth).clear();
			driver.findElement(formBmonth).sendKeys(userBmonth);
		}
	}
	
	public void fillByear(String userByear) {
		if(IsElementPresent(formByear)) {
			driver.findElement(formByear).click();
			driver.findElement(formByear).clear();
			driver.findElement(formByear).sendKeys(userByear);
		}
	}
	
	public void fillGender(String gender) {
		switch (gender) {
			case "male":
				fillGenderMale();
				break;
			case "feminine" :
				fillGenderFeminine();
				break;
		}
	}
	
	public void fillGenderMale() {
		if(IsElementPresent(formGenderPicker)) {
			driver.findElement(formGenderPicker).click();
			driver.findElement(By.xpath("//form[@id='mG61Hd']/div/div[2]/div[2]/div[4]/div[2]/div/div/div")).click();
			driver.findElement(By.xpath("//form[@id='mG61Hd']/div/div[2]/div[2]/div[4]/div[2]/div[2]/div[3]")).click();
		}
	}
	
	public void fillGenderFeminine() {
		if(IsElementPresent(formGenderPicker)) {
			driver.findElement(formGenderPicker).click();
			driver.findElement(By.xpath("//form[@id='mG61Hd']/div/div[2]/div[2]/div[4]/div[2]/div/div[2]")).click();
			driver.findElement(By.xpath("//form[@id='mG61Hd']/div/div[2]/div[2]/div[4]/div[2]/div[2]/div[4]/content")).click();
		}
	}
	
	public String getGenderTitle() {
		String genderTitle = driver.findElement(formGenderTitle).getText();
		
		return genderTitle;
	}
	
	
	public void fillHowAreYou(String number) {
		String xpath = formHawAreYouPickPath.substring(0, 66) + number + formHawAreYouPickPath.substring(67);
		
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void fillOther(String other) {
		if(IsElementPresent(formFildOther)) {
			driver.findElement(formFildOther).click();
			driver.findElement(formFildOther).sendKeys(other);
		}
	}
	
	public void submitForm() {
		if(IsElementPresent(formSubmitButton)) {
			driver.findElement(formSubmitButton).click();
		}	
	}
	
	public List<String> getHowAreYouList()
    {
		List<String> groups = new ArrayList<String>();

        List<WebElement> elements = driver.findElement(formHowAreYouBlock).findElements(By.tagName("div"));
        
        for(int i = 0; i < elements.size(); i++)
        {
        	if (elements.get(i).getAttribute("data-value") != null) {
        		String title = elements.get(i).getAttribute("data-value");
            	groups.add(title);
        	}
        }
        return groups;
    }
	
	public List<String> getErrorsList()
    {
		List<String> errors = new ArrayList<String>();

        List<WebElement> errorsTitle = driver.findElements(formErrorTite);
        
        for(int i = 0; i < errorsTitle.size(); i++)
        {
        	String title = errorsTitle.get(i).getText();
            errors.add(title);
        }
        return errors;
    }
}
