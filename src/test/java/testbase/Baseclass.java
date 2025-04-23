package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass
{
	
	public WebDriver driver;
	public  Logger logger;
	public Properties p;
	
	@BeforeClass(groups={"sanity","reggression","datadriver"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());
		
		FileInputStream file=new FileInputStream("./src/test/resources/prop.properties");
		p=new Properties();
		p.load(file);
		
		
		
		switch(br)
		{
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		default:System.out.println("invalid browser");return;
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
	}
	
	public String getrandomstring()
	{
		String randomstring = RandomStringUtils.randomAlphabetic(7);
		return randomstring;
	}

	public String getrandomalphanumeric()
	{
		String pwd = RandomStringUtils.randomAlphanumeric(5);
		return pwd;

	}

	public String getrandomnumbers() 
	{
		String numbers = RandomStringUtils.randomNumeric(10);
		return numbers;
	}
	@AfterClass(groups={"sanity","reggression","datadriver"})
	public void teardown()
	{
		driver.close();
	}

}
