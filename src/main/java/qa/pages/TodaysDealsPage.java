package qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class TodaysDealsPage extends TestBase {

	TodaysDealsPage todaysDealPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public TodaysDealsPage() {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="(//div[@class='nav-progressive-content']//a)[1]")
	WebElement todayDeals;
	
	@FindBy(xpath="(//span[contains(text(),'Computers & Accessories')])[1]")
	WebElement dealCategory;
	
	@FindBy(xpath="//ul[@class='a-nostyle']//input[@data-csa-c-element-id='filter-department-541966']")
	private WebElement checkbox;
	
	public boolean categoryCheck() throws InterruptedException{
		todayDeals.click();
		
		
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", dealCategory);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		dealCategory.click();
		return dealCategory.isDisplayed();
	}
	public boolean checkBoxChecked() throws InterruptedException {
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Thread.sleep(2000);
		return checkbox.isSelected();
	}
	
}
