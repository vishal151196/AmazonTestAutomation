package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.pages.OrderPage;
import qa.util.TestUtil;

public class OrderPageTest extends TestBase {

	OrderPage orderPage;
	HomePage homePage;
	LoginPage loginPage;
	String sheetName = "amazonPurchaseSheet";
	public int ItemCounter=0;

	public OrderPageTest() {
		super(); // this will call TestBase class constructor for intializing required properties
		
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		orderPage = new OrderPage();
		

		String uname = prop.getProperty("username");
		String pass = prop.getProperty("password");

		loginPage.login(uname, pass);
	}

	@DataProvider
	public Object[][] getAmazonProductData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

//	@Test(priority = 1, dataProvider = "getAmazonProductData")
//	public void searchResults(String Product, String MaterialType, String Brand, String MinPrice,
//			String MaxPrice) throws InterruptedException  {
//		
//		//System.out.println(Product + " : " + Color + " : " + MaterialType + " : " + Brand + " : " + MinPrice + MaxPrice);
//		
//		orderPage.Search(Product);		
//		Assert.assertTrue(orderPage.searchResultTagCheck(Product));
//
//		//Assert.assertTrue(orderPage.NumberOfItemsAdded(ItemCounter.toString()));
//		 //Assert.assertTrue(orderPage.CartCheck());
//	}
//	@Test(priority = 2, dataProvider = "getAmazonProductData")
//	public void SetItemPreference(String Product, String MaterialType, String Brand, String MinPrice,
//			String MaxPrice) throws InterruptedException  {
//		orderPage.Search(Product);
//		Assert.assertTrue(orderPage.ItemPreference(MinPrice,MaxPrice), "SetItemPreference Test Failed:");
//		 
//		
//	}
//	@Test(priority = 3, dataProvider = "getAmazonProductData")
//	public void FirstProductClick(String Product, String MaterialType, String Brand, String MinPrice,
//			String MaxPrice) throws InterruptedException  {
//		orderPage.Search(Product);
//		orderPage.ItemPreference(MinPrice,MaxPrice);
//		Assert.assertTrue(orderPage.ClickonFirstProduct(), "FirstProductClick Test Failed:");
//
//	}
	@Test(priority=4, dataProvider = "getAmazonProductData")
	public void OrderCheck(String Product, String MaterialType, String Brand, String MinPrice,
			String MaxPrice) throws InterruptedException {
		orderPage.Search(Product);
		orderPage.ItemPreference(MinPrice,MaxPrice);
		orderPage.ClickonFirstProduct();
		Assert.assertTrue(orderPage.GoToCart(), "OrderCheck Test Failed:");
	}
	@AfterMethod
	public void tearDown() {
 		driver.quit();
	}
}