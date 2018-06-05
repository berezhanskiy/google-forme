package A4.Google_form;

import org.testng.annotations.Test;
import junit.framework.Assert;

public class NegativeTests extends BaseTest {
  
	@Test //check that fields are required and form did not submitted
	public void emptyFildsTest() {
		formManager.submitForm();
		formManager.getErrorsList();
		
		Assert.assertEquals(5, formManager.getErrorsList().size());
		Assert.assertEquals("Відповідь на це запитання обов’язкова", formManager.getErrorsList().get(0));
	}
	
	@Test //check that invalid email should not submitted
	public void notValidEmailTest() {
		formManager.fillEmail("bla-bla");
		formManager.getErrorsList();
		
		Assert.assertEquals("Потрібна дійсна електронна адреса", formManager.getErrorsList().get(0));
	}
	
	@Test //check that invalid Date should not submitted
	public void notValidDateTest() {
		formManager.fillDate("asd", "11", "1990");
		formManager.getErrorsList();
		
		Assert.assertEquals("Недійсна дата", formManager.getErrorsList().get(1));
	}
	
	@Test //check Name characters limit (20 symbols)
	public void notValidNameTest() {
		formManager.fillName("testtesttesttesttest1");
		formManager.submitForm();
		
		Assert.assertEquals("Максимальное количество символов 20 превышено", formManager.getErrorsList().get(2));
	}

}
