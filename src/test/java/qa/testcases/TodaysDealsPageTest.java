package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.pages.TodaysDealsPage;

public class TodaysDealsPageTest extends TestBase{

	 
	 LoginPage loginPage;
	 HomePage homePage;
	 TodaysDealsPage todaysDealPage;
	 
	 public TodaysDealsPageTest() {
		 super(); // this will call TestBase class constructor for intializing required properties
	 }
	 
	 @BeforeMethod
		public void setUp() throws InterruptedException {
			initialization();
			
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
			todaysDealPage = homePage.todayDealObj(); //it assigns object otherwise this.null error
		}
	 
	 @Test(priority = 1)
		public void categoryCheckTest() throws InterruptedException {
			boolean flag1 = todaysDealPage.categoryCheck();
			System.out.println("Category is: "+flag1);

			Assert.assertTrue(flag1);
		}
	 @Test(priority = 2)
		public void checkBoxTest() throws InterruptedException {
		 	todaysDealPage.categoryCheck();
			boolean flag2 = todaysDealPage.checkBoxChecked();
			System.out.println("CheckboxTest is: "+flag2);
			Assert.assertTrue(flag2);
		}
	 
	 @AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
