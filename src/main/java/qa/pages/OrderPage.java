package qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

//	@FindBy(xpath = "//span[@class='a-button-inner']//span[contains(text(),'Go')]")
	@FindBy(xpath = "//span[@class='a-button-inner']//input")
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
	@FindBy(xpath = "//a[@href='/cart?ref_=sw_gtc']")
	WebElement goToCart;

	@FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
	WebElement cartSubtotal;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	// enter item to search
	public boolean Search(String Product) throws InterruptedException {
		searchBox.sendKeys(Product);
		searchBtn.click();
		String result = searchResultTag.getText().toString().replaceAll("^\"|\"$", "");
		boolean flag = result.equals(Product);
		return flag;
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

		
		minPrice.sendKeys(MinPrice);
		maxPrice.sendKeys(MaxPrice);
//		Thread.sleep(00);
//		try {
//			js.executeScript("arguments[0].scrollIntoView(true);", priceGoBtn);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(priceGoBtn));
		priceGoBtn.click();
		return firstProduct.isDisplayed();
		
	}

	// click on first product
	public boolean ClickonFirstProduct() throws InterruptedException {
		Thread.sleep(500);
		firstProduct.click();
//		Thread.sleep(500);
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", addToCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		addToCart.click();
		return addItemSuccess.isDisplayed();
	}

	public boolean GoToCart() {
		goToCart.click();
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", cartSubtotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag= cartSubtotal.isDisplayed();
		return flag;
	}

}
