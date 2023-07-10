package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object Repository:
	
	@CacheLookup
	@FindBy(xpath = "(//a[@data-nav-role='signin'])[1]")
	WebElement signInBtn;
	
	@CacheLookup
	@FindBy(xpath = "//input[@type='email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement btnContinue;

	@FindBy(id =  "ap_password")
	WebElement password;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement amazonLogo;

	@FindBy(xpath = "(//div[@id='glow-ingress-block']/span)[1]")
	WebElement signInConfirmation;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateAmazonImage() {
		return amazonLogo.isDisplayed();
	}

	public boolean validatesignInConfirmation() {
		return signInConfirmation.isDisplayed();
	}

	public HomePage login(String un, String pwd) {

		signInBtn.click();
		
		username.sendKeys(un);
		btnContinue.click();		
		password.sendKeys(pwd);
		loginBtn.click();


		return new HomePage();
	}
}
