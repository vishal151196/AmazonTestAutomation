package qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.TestBase;

public class OrderPage extends TestBase {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath ="//input[@placeholder='Search Amazon']")
	WebElement searchBox;

	@FindBy(xpath = "//div[@class='sg-col-inner']/div/span[3]")
	WebElement searchResultTag;

	@FindBy(xpath = "//input[@placeholder='Min']")
	WebElement minPrice;

	@FindBy(xpath = "//span[contains(text(),'Embellishment Feature')]")
	WebElement temp;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchBtn;

	@FindBy(xpath = "//input[@placeholder='Max']")
	WebElement maxPrice;

	@FindBy(xpath = "//span[@class='a-button-inner']//input[@type='submit']")
	WebElement priceGoBtn;
	
	@FindBy(xpath= "//div[@id='topRefinements/-1']")
	WebElement preferenceTag;

	@FindBy(xpath = "(//div[@data-index='2'])[1]")
	WebElement firstProduct;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCart;
	
	@FindBy(xpath ="//span[contains(text(),'Added to Cart')]")
	WebElement addItemSuccess;
	
//	@FindBy(xpath= "//a[@id='nav-cart']")
//	WebElement cart;
	
	//input[@id='add-to-cart-button']

	//@FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
	//WebElement closePopup;

//	@FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
//	WebElement NumberOfItemsAdded;
//
	@FindBy(xpath = "(//a[contains(text(),\"Go to Cart\")])[2]")
	WebElement goToCart;

	@FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
	WebElement cartSubtotal;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	// enter item to search
	public void Search(String Product) throws InterruptedException {
		searchBox.sendKeys(Product);
		searchBtn.click();
//		Thread.sleep(500);
//		addToCart.click();
//		ClickonFirstProduct();

		
//		addToCart();
		
		// ++ItemCounter;

	}

	// check if search has given correct result or not
	public boolean searchResultTagCheck(String Product) {

		String result = searchResultTag.getText().toString().replaceAll("^\"|\"$", "");
		return result.equals(Product);
	}

	// select different preferences of particular product
	public boolean ItemPreference(String MinPrice, String MaxPrice) throws InterruptedException {

		try {
			js.executeScript("arguments[0].scrollIntoView(true);", temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(100);
		minPrice.sendKeys(MinPrice);
		maxPrice.sendKeys(MaxPrice);
//		Thread.sleep(00);
		priceGoBtn.click();
		return firstProduct.isDisplayed();
		
	}

	// click on first product
	public boolean ClickonFirstProduct() throws InterruptedException {
		Thread.sleep(500);
		firstProduct.click();
		Thread.sleep(500);
		addToCart.click();
		return addItemSuccess.isDisplayed();
	}
	
	
//	public boolean NumberOfItemsAdded(String NoofProducts) {
//		try {
//			js.executeScript("arguments[0].scrollIntoView(true);", NumberOfItemsAdded);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		 String NoOfitems= NumberOfItemsAdded.getText().toString();
//		 NoofProducts = "Subtotal ("+NoofProducts+" item";
//		 System.out.println(NoofProducts);
//		 try {
//				js.executeScript("arguments[0].scrollIntoView(true);", NumberOfItemsAdded);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		 return NoOfitems.equals(NoofProducts);
//	}
	public boolean GoToCart() {
		goToCart.click();
		return cartSubtotal.isDisplayed();
	}

//	public boolean CartCheck() {
//		
//	}

}
