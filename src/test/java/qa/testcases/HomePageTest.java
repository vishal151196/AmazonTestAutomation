package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginPage;


public class HomePageTest extends TestBase {

	 HomePage homePage;
	 LoginPage loginPage;

		public HomePageTest() {
			super(); // this will call TestBase class constructor for intializing required properties

		}
		
		@BeforeMethod
		public void setUp() throws InterruptedException {
			initialization();
			
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		}

		@Test(priority = 1)
		public void CustomerNameTest() {
			boolean flag1 = homePage.validateCustomerName();
	
			Assert.assertTrue(flag1);
		}
		@Test(priority = 2)
		public void MenuTest() throws InterruptedException {
			boolean flag2 = homePage.clickHomeMenu();
			Assert.assertTrue(flag2);
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}
