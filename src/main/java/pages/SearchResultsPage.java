package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage {

	WebDriver driver;
	ElementUtils elementUtils;
	public SearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	public boolean displayStatusOfValidProduct()
	{
		return elementUtils.displayStatusOfElement(validHPProduct,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(xpath="//input[@id=\"button-search\"]/following-sibling::p")
	private WebElement messageText;
	
	public String getMessageText()
	{
		return elementUtils.getTextFromElement(messageText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
}
