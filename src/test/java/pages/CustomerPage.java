package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CustomerPage {

	WebDriver driver;
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]/i")
	WebElement btn_customer;

	@FindBy(how = How.XPATH, using = "//a[@href='/Admin/Customer/List']//p[1]")
	WebElement link_customer;

	@FindBy(how = How.XPATH, using = "//a[@href='/Admin/Customer/Create']")
	WebElement addNew_Btn;

	public void clickBtnCustomer() {
		executor.executeScript("arguments[0].click();", btn_customer);
	}

	public void clickCustomerFromDropDown() {
		executor.executeScript("arguments[0].click();", link_customer);
	}

	public AddCustomerPage clickAddNewBtn() {
		addNew_Btn.click();
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		return addCustomerPage;
		
	}

}