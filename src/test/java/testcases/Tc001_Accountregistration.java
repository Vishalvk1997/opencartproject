package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Registerpage;
import testbase.Baseclass;

public class Tc001_Accountregistration extends Baseclass{
	
	@Test(groups="regression")
	public void Verify_account_register()
	{
		try {
		Homepage hm = new Homepage(driver);
		logger.info("starterd Verify_account_register");
		hm.clickonmyaccount();
		logger.info("clicked on my account");
		hm.clickonregister();
		
		Registerpage rp = new Registerpage(driver);
		rp.enterfirstname(getrandomstring());
		rp.enterlatstname("hyfhfhfh");
		String emailaddress=getrandomstring();
        rp.enteremail( emailaddress+ "@gmail.com");
		String passwrd = getrandomalphanumeric();
		rp.enterpassword(passwrd);
		rp.confirmpassword(passwrd);
		rp.telephone(getrandomnumbers());
		rp.privacypolicy();
		rp.clickoncontinue();
		String cnfmsg = rp.getConfirmationMsg();
		System.out.println(emailaddress);
		System.out.println(passwrd);

		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			logger.debug("debug..................");
			Assert.fail();
			
			
		
		}
	}

	

}
