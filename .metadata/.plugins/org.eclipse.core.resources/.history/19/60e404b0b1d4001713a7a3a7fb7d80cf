package PlatformTesting.com.platform.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PlatformHelper.HelperClass;

public class PersonabarPageTest 
{
	public WebDriver driver;
	@Test(groups= "Personabar Settings")
	public void checkPersonabarSettings() 
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/login");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		login_page.login_engage("Host","dnnhost"); 
		PersonaBarClass persona = PageFactory.initElements(driver, PersonaBarClass.class);
		persona.PersonabarOpenContent(driver);
		driver.quit();
	}
}
