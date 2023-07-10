package qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;



public class HomePage extends TestBase {
	
	
	HomePage homePage;
	
	
	
	// Initializing the Page Objects:
		public HomePage() {

			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//span[contains(text(),'Hello, Vishal')]")
	WebElement customerinfo;
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
	WebElement homeMenu;
	
//	
	@FindBy(xpath = "(//a[@class=\"hmenu-item\"])[35]")
	WebElement signOut;
	@FindBy(xpath="//div//ul[@class='hmenu hmenu-visible']]")
	WebElement scrollToView;
	
//	js.executeScript("window.scrollBy(0,250)", "");
	
	
	public boolean validateCustomerName(){
		return customerinfo.isDisplayed();
	}
	public boolean clickHomeMenu() throws InterruptedException{
		homeMenu.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", signOut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		return signOut.isDisplayed();
	}
	public TodaysDealsPage todayDealObj() {
		return new TodaysDealsPage();
	}


}
