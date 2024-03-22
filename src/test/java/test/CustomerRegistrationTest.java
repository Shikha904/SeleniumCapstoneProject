package test;

import org.junit.Test;
import basePage.BaseTest;
import pages.AddCustomerPage;
import pages.CustomerPage;
import utility.Constants;

public class CustomerRegistrationTest extends BaseTest {

	@Test
	public void verifyCustomer() throws Exception {
		CustomerPage customerPage= loginpage.loginApplication(Constants.username, Constants.password);
		verifyApplicationTitle(Constants.nopCommerceTitle);
		customerPage.clickBtnCustomer();
		customerPage.clickCustomerFromDropDown();
		AddCustomerPage addCustomerPage= customerPage.clickAddNewBtn();
		verifyApplicationTitle(Constants.nopCommerceAddNewCustTitle);
		addCustomerPage.addNewCustomer("sampletest@gmail.com", "sampletesting", "test", "test", "04/10/1970", "Incedo");
		String alertMesg = addCustomerPage.getConfirmationMsg();
		System.out.println(alertMesg);
		loginpage.clickLogout();
		verifyApplicationTitle(Constants.nopCommerceHomePageTitle);
		
	}
}