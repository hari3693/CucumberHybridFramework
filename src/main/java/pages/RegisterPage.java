package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	public void enterFirstName(String firstNameText)
	{
		elementUtils.typeTextIntoElement(firstNameField, firstNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	public void enterLastName(String lastNameText)
	{
		elementUtils.typeTextIntoElement(lastNameField, lastNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmailAddress(String emailText)
	{
		elementUtils.typeTextIntoElement(emailField, emailText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephoneNumber(String telephoneText)
	{
		elementUtils.typeTextIntoElement(telephoneField, telephoneText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordField, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	public void enterConfirmPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordConfirmField, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	public void selectPrivacyPolicy()
	{
		elementUtils.clickOnElement(privacyPolicyOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement continueButton;
	
	public AccountSucessPage clickOnContinueButton()
	{
		elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new AccountSucessPage(driver);
	}
	
	@FindBy(xpath="//input[@name=\\\"newsletter\\\"][@value=\\\"1\\\"]")
	private WebElement YesToNewsletterOption;
	
	public void selectYesNewsletterOption()
	{
		elementUtils.clickOnElement(YesToNewsletterOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(xpath="//div[text()=\"Warning: No match for E-Mail Address and/or Password.\"]")
	private WebElement warningMessage;
	
	public String getWarningMessageText()
	{
		return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(xpath="//input[@id=\\\"input-firstname\\\"]/following-sibling::div")
	private WebElement firstNameWarning;
	
	public String getFirstNameWarning()
	{
		return elementUtils.getTextFromElement(firstNameWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(xpath="//input[@id=\\\"input-lastname\\\"]/following-sibling::div")
	private WebElement lastNameWarning;
	
	public String getlastNameWarning()
	{
		
		return elementUtils.getTextFromElement(lastNameWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath="//input[@id=\\\"input-email\\\"]/following-sibling::div")
	private WebElement emailWarning;
	
	public String getemailWarning()
	{
		return elementUtils.getTextFromElement(emailWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	
	@FindBy(xpath="//input[@id=\\\"input-telephone\\\"]/following-sibling::div")
	private WebElement telephoneeWarning;
	
	public String getTelephoneWarning()
	{
		return elementUtils.getTextFromElement(telephoneeWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath="//input[@id=\\\"input-password\\\"]/following-sibling::div")
	private WebElement passwordWarning;
	
	public String getPasswordWarning()
	{
		return elementUtils.getTextFromElement(passwordWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
