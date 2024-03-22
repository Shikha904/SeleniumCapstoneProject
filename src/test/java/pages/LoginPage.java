package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.NAME , using = "Email")
	WebElement userEmail;

	@FindBy(how=How.XPATH, using = "//*[@name='Password']")
	WebElement password;

	@FindBy(how=How.XPATH, using = "//*[text()='Remember me?']")
	WebElement chkRem;

	@FindBy(how=How.CSS, using= ".button-1.login-button")
	WebElement btnLogin;

	@FindBy(how=How.LINK_TEXT, using = "Logout")
	WebElement btnLogout;

	public void clickLogout() {
		btnLogout.click();
	}
	
	public CustomerPage loginApplication(String email, String pwd)
	{
		userEmail.clear();
		userEmail.sendKeys(email);
		password.clear();
		password.sendKeys(pwd);
		chkRem.click();
		btnLogin.click();
		CustomerPage customerPage = new CustomerPage(driver);
		return customerPage;
	}

	
}
