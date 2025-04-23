package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage 
{
         public Homepage(WebDriver driver)
         {
        	 super(driver);
         }
         
         @FindBy(xpath="//a[@title='My Account']")
         WebElement myaccount;
         @FindBy(xpath="//a[normalize-space()='Register']")
         WebElement register;
         @FindBy(xpath="//a[normalize-space()='Login']")
         WebElement login;
       
         
         public void clickonmyaccount()
         {
        	 myaccount.click();
         }
         public void clickonregister()
         {
        	 register.click();
         }
         public void clickonlogin()
         {
        	 login.click();
         }
        
}
