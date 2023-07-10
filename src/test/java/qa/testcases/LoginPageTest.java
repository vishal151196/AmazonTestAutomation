package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	// HomePage homePage;

	public LoginPageTest() {
		super(); // this will call TestBase class constructor for intializing required properties
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println("Page title : " + title);

		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}

	@Test(priority = 2)
	public void amazonLogoImageTest() {
		boolean flag1 = loginPage.validateAmazonImage();
		System.out.println("Actual Image isDisplayed : " + flag1);
		Assert.assertTrue(flag1);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		String uName = prop.getProperty("username");
		String pass = prop.getProperty("password");
		System.out.println("Entering UserName : " + uName);
		System.out.println("Entering Password : " + pass);

		loginPage.login(uName, pass);
		
		//check for login
		boolean flag2 = loginPage.validatesignInConfirmation();
		System.out.println("Confirmation isDisplayed : " + flag2);
		Assert.assertTrue(flag2);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
