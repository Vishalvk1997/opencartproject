package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import testbase.Baseclass;

public class Tc002_loginverify extends Baseclass {
	@Test(groups="sanity")
	public void logintest() {
		try {
			logger.info("verify started.........................");
			Homepage hm = new Homepage(driver);
			hm.clickonmyaccount();
			hm.clickonlogin();
			Loginpage lp = new Loginpage(driver);

			lp.enteremail(p.getProperty("email"));
			lp.enterpassword(p.getProperty("password"));
			lp.clickonloginbtn();

			Myaccountpage myacc = new Myaccountpage(driver);
			boolean targetpage = myacc.ismyaccoumtexist();
			Assert.assertTrue(targetpage);
			logger.info("finished login test");
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
