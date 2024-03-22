package basePage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pages.LoginPage;
import utility.ReadConfig;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPage loginpage;
	ReadConfig config;

	@Before
	public void initializeDriver() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//TestData//config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		// chrome
		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			// Firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		config = new ReadConfig();
		driver.get(config.getAppURL());
		loginpage = new LoginPage(driver);
		//customerPage = new CustomerPage(driver);
		//addCustomerPage = new AddCustomerPage(driver);

	}

	public void verifyApplicationTitle(String expTitle) throws Exception {
		Assert.assertEquals(driver.getTitle(), expTitle);
	}


	@After
	public void CloseApp() throws Exception {
		driver.close();
		driver.quit();
	}

}