package PlatformTesting.com.platform.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PlatformHelper.HelperClass;

public class PersonabarPageTest 
{
	public WebDriver driver;
	@Test(groups= "PersonabarPages", priority = 5)
	public void checkPersonabarPages() 
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		login_page.login_engage(driver,"Host","dnnhost"); 
		PersonaBarPageClass persona = PageFactory.initElements(driver, PersonaBarPageClass.class);
		persona.PersonabarOpenPages(driver);
	}
	@Test(groups= "PersonabarPages", priority = 6)
	public void PersonabarCreatePage() 
	{
		int randNum = (int) (Math.random() * 1000); // generate random number
		PersonaBarPageClass persona = PageFactory.initElements(driver, PersonaBarPageClass.class);
		persona.PersonabarCreatePage(driver, "PAGEName"+randNum);
		//return("PAGEName"+randNum);
	}	
	
}
