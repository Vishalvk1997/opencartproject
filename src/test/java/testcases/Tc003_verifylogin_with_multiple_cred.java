package testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import testbase.Baseclass;
import utilities.Dataprovider;

public class Tc003_verifylogin_with_multiple_cred extends Baseclass {
	@Test(dataProvider = "logindata", dataProviderClass = Dataprovider.class, groups= {"sanity","master","datadriven"})
	public void verifyloginDDT(String email, String pwd, String exp) {
		try {
			Homepage hm = new Homepage(driver);
			logger.info("starterd Verify_");
			hm.clickonmyaccount();
			hm.clickonlogin();
			Loginpage lp = new Loginpage(driver);
			lp.enteremail(email);
			lp.enterpassword(pwd);
			lp.clickonloginbtn();

			Myaccountpage macc = new Myaccountpage(driver);
			boolean targetpage = macc.ismyaccoumtexist();

			if (exp.equalsIgnoreCase("valid")) {
				if (targetpage == true) {
					macc.clickonlogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}
			if (exp.equalsIgnoreCase("invalid")) {
				if (targetpage == true) {
					macc.clickonlogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
