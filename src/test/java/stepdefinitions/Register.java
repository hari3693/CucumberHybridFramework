package stepdefinitions;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSucessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;
public class Register {
	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSucessPage accountSucessPage;
	private CommonUtils commonUtils;
	
	
	@Given("User navigates to Register Account  page")
	public void user_navigates_to_register_account_page() {
	    
		
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerpage = homePage.selectRegisterOption();
		
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		commonUtils = new CommonUtils();
		registerpage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		registerpage.enterTelephoneNumber(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(dataMap.get("email"));
		registerpage.enterTelephoneNumber(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("password"));
		
	}
	
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	    
		registerpage.selectPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	    
		accountSucessPage = registerpage.clickOnContinueButton();
	}

	@Then("User account should get created sucessfully")
	public void user_account_should_get_created_sucessfully() {
		
		Assert.assertEquals("Your Account Has Been Created!", accountSucessPage.getPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		registerpage.selectYesNewsletterOption();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	    
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerpage.getWarningMessageText());
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	   
		registerpage.enterFirstName(" ");
		registerpage.enterLastName(" ");
		registerpage.enterEmailAddress(" ");
		registerpage.enterTelephoneNumber(" ");
		registerpage.enterPassword(" ");
		registerpage.enterConfirmPassword(" ");
		
	}


	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	    
		Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning You must agree to the Privacy Policy!"));
		Assert.assertTrue(registerpage.getFirstNameWarning().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerpage.getlastNameWarning().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerpage.getemailWarning().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(registerpage.getTelephoneWarning().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerpage.getPasswordWarning().contains("Password must be between 4 and 20 characters!"));
		
	}

	
}
