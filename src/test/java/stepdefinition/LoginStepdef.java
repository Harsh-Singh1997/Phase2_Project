package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef {

WebDriver driver = Hooks.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	   
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS );
        }
	
	@When("I enter username as {string} and password as {string}")
	public void i_enter_username_as_and_password_as(String Usernameval, String Pswval) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user-name"));
        UserName.sendKeys(Usernameval);
        
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys(Pswval); 
	}

	@When("I Click the Login Button")
	public void i_Click_the_Login_Button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement LoginButton = driver.findElement(By.name("login-button"));
        LoginButton.click();
	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
		
	}

	@Then("I should get error message {string}")
	public void i_should_get_error_message(String ExpError) {
	    // Write code here that turns the phrase above into concrete actions
	    
		WebElement Error = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
		String ActError = Error.getText();
		Assert.assertEquals(ExpError, ActError);
	}

	@When("I click on Add to Cart of {string}")
	public void i_click_on_Add_to_Cart_of(String ProductName) {
	    // Write code here that turns the phrase above into concrete actions
		String Xpath = "//div[text()='" +  ProductName + "']//following::button[1]";
		WebElement ProductButton = driver.findElement(By.xpath(Xpath));
		ProductButton.click();
	}

	@Then("Cart value increased")
	public void cart_value_increased() {
	    // Write code here that turns the phrase above into concrete actions
	    
		WebElement AddtoCartItem = driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]"));
		String ItemNo = AddtoCartItem.getText();
		Assert.assertEquals(ItemNo,"1");
	}

	
}
