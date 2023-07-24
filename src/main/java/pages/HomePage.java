package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public LoginPage selectLoginOption()
	{
		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new LoginPage(driver);
	}
	
	@FindBy(xpath="//span[text()=\"My Account\"]")
	private WebElement myAccountDropMenu;
	
	public void clickOnMyAccount()
	{
		elementUtils.clickOnElement(myAccountDropMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public RegisterPage selectRegisterOption()
	{
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new RegisterPage(driver);
	}
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	public void enterProductIntoSearchBox(String validProductText)
	{
		elementUtils.typeTextIntoElement(searchBoxField, validProductText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(xpath="//button[contains(@class,\"btn-default\")]")
	private WebElement searchButton;
	
	public SearchResultsPage clickOnSearchButton()
	{
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new SearchResultsPage(driver);
	}
	
}
