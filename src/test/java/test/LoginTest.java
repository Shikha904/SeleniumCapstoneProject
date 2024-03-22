package test;

import org.junit.Test;
import basePage.BaseTest;
import utility.Constants;

public class LoginTest extends BaseTest {

	@Test
	public void verifyLoginFeature() throws Exception {
		loginpage.loginApplication(Constants.username, Constants.password);
		verifyApplicationTitle(Constants.nopCommerceTitle);
		loginpage.clickLogout();
		verifyApplicationTitle(Constants.nopCommerceHomePageTitle);
	}
}