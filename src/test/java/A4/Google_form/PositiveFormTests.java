package A4.Google_form;

import org.testng.annotations.Test;
import junit.framework.Assert;

public class PositiveFormTests extends BaseTest{
 	
	@Test  //check that form should be submitted with all fields and correct data
	       //check feminine gender and picks all how are you
	public void correctDataForFeminineTest() {
		formManager.fillEmail("test@test.com");
		formManager.fillDate("10", "10", "1990");
		formManager.fillName("test user");
		formManager.fillGender("feminine");
		formManager.fillHowAreYou("1");
		formManager.fillHowAreYou("2");
		formManager.fillHowAreYou("3");
		formManager.fillHowAreYou("4");
		formManager.fillHowAreYou("5");
		formManager.fillOther("bla-bla-bla-bla-bla");
		formManager.submitForm();
		
		Assert.assertEquals(6, formManager.getHowAreYouList().size());
		Assert.assertEquals("Вашу відповідь було записано.", responseFormManager.getResultTitle());
		
	}
	
	@Test  //check that form should be submitted with all fields and correct data
    	   //check male gender and pick one how are you
	public void correctDataForMaleTest() {
		formManager.fillEmail("test@test.com");
		formManager.fillDate("05", "11", "1990");
		formManager.fillName("test user");
		formManager.fillGender("male");
		formManager.fillHowAreYou("4");
		formManager.submitForm();
		
		Assert.assertEquals("Вашу відповідь було записано.", responseFormManager.getResultTitle());
	}
}
