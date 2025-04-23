package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage 
{

 public	Loginpage(WebDriver driver)
 {
		super(driver);
 }

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailfield;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	
	
	
	public void enteremail(String email)
	{
		emailfield.sendKeys(email);
	}
	public void enterpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickonloginbtn()
	{
		loginbtn.click();
	}
	
	}