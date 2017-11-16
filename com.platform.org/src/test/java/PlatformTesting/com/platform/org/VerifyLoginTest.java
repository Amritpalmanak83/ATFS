package PlatformTesting.com.platform.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import PlatformHelper.HelperClass;
import PlatformTestDataSheet.ExcelDataSheet;

public class VerifyLoginTest 
{
	public WebDriver driver;
	@Test(priority=1)
	public void checkvalidUser() 
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/login");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		login_page.login_engage("Host","dnnhost"); 
	}
	@Test(priority=2)
	public void personabarcheck()
	{
		PersonaBarClass persona = PageFactory.initElements(driver, PersonaBarClass.class);
		persona.PersonabarOpenContent(driver);
	}
	@Test(priority=3)
	public void checkvalidLogin()
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/login");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		ExcelDataSheet excel = new ExcelDataSheet("C:\\Users\\Amrit\\Documents\\ATFS\\com.platform.org\\Data\\TestDataSheet.xlsx");
		String userName[] = excel.getUserData(0, 0);
		login_page.login_engage(userName[0],userName[1]); 
	}
	@Test(priority=4)
	public void createvalidLogin()
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/register");
		driver.manage().window().maximize();
		LoginRegistrationClass Register_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		ExcelDataSheet excel = new ExcelDataSheet("C:\\Users\\Amrit\\Documents\\ATFS\\com.platform.org\\Data\\TestDataSheet.xlsx");
		for (int i=0;i<4; i++)
		{
			String userinfo[] = excel.getUserInfo(1, i);
			Register_page.register_user(userinfo[0],userinfo[1],userinfo[2],userinfo[3]); 
			driver.navigate().to("http://platform92.me/register");
		}
	}
}
