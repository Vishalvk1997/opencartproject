package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registerpage extends Basepage {
	public Registerpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lasttname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirm;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement newsletter;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement aggree;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebtn;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement confirmationmsg;

	public void enterfirstname(String fstname) {
		firstname.sendKeys(fstname);
	}

	public void enterlatstname(String lstname) {
		lasttname.sendKeys(lstname);
	}

	public void enteremail(String mail) {
		email.sendKeys(mail);
	}

	public void telephone(String mobnum) {
		telephone.sendKeys(mobnum);
	}

	public void enterpassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void confirmpassword(String pwd) {
		confirm.sendKeys(pwd);
	}

	public void privacypolicy() {
		aggree.click();
	}

	public void clickoncontinue() {
		continuebtn.click();
	}

	public String getConfirmationMsg() {
		try {
			return confirmationmsg.getText();
		} catch (Exception e) {
			e.printStackTrace(); // Optional: logs the exception
			return null; // Or return "" if you prefer an empty string
		}
	}

}
