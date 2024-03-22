package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[text()='Customer info']/following-sibling::div")
	private WebElement custInfo;

	@FindBy(how = How.CSS, using = "input#Email")
	private WebElement email_txtBox;

	@FindBy(how = How.CSS, using = "input#Password")
	private WebElement password;

	@FindBy(how = How.NAME, using = "FirstName")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "LastName")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//*[@value='F']")
	WebElement gender_radioBtn;

	@FindBy(how = How.CSS, using = "input#DateOfBirth")
	private WebElement dateOfBirth;

	@FindBy(how = How.ID, using = "Company")
	WebElement companyName;

	@FindBy(how = How.CSS, using = "input#IsTaxExempt")
	WebElement consentCheckBox;

	@FindBy(how = How.XPATH, using = "//select[@id='SelectedNewsletterSubscriptionStoreIds']")
	private WebElement newsLetterDropDown;

	@FindBy(how = How.XPATH, using = "//button[@name='save']")
	private WebElement save;
	

	@FindBy(how = How.XPATH, using = "//*[@class='alert alert-success alert-dismissable']")
	private WebElement txtMsg;

	public void addNewCustomer(String email, String pwd, String Fname, String Lname, String dob, String CompanyName) {
		custInfo.click();
		email_txtBox.sendKeys(email);
		password.sendKeys(pwd);
		firstName.sendKeys(Fname);
		lastName.sendKeys(Lname);
		gender_radioBtn.click();
		dateOfBirth.sendKeys(dob);
		companyName.sendKeys(CompanyName);
		consentCheckBox.click();
		save.click();
	}
	
	public String getConfirmationMsg()
	{
		return txtMsg.getText();
		
	}
}