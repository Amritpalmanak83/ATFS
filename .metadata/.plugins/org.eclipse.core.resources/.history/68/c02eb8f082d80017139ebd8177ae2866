package PlatformTesting.com.platform.org;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PlatformDataBaseTesting.PlatformDataBaseTest;
import PlatformHelper.HelperClass;
import PlatformTestDataSheet.ReadExcelDataSheet;

public class VerifyLoginTest 
{
	public WebDriver driver;
	@Test(groups= "UserTest",priority = 1)
	public void checkvalidUser() 
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		login_page.login_engage(driver,"Host","dnnhost"); 
		driver.quit();
	}
	@Test(groups= "UserTest", priority = 2)
	public void checkvalidLogin()
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		ReadExcelDataSheet rd_excel = new ReadExcelDataSheet("C:\\Users\\Amrit\\Documents\\ATFS\\com.platform.org\\Data\\TestDataSheet.xlsx");
		String userinfo[] = rd_excel.getUserData(0, 0);
		login_page.login_engage(driver, userinfo[0],userinfo[1]); 
		driver.quit();
	}
	@Test(groups= "UserTest", priority = 3)
	public void registerUser()
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/");
		driver.manage().window().maximize();
		LoginRegistrationClass Register_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		ReadExcelDataSheet rd_excel = new ReadExcelDataSheet("C:\\Users\\Amrit\\Documents\\ATFS\\com.platform.org\\Data\\TestDataSheet.xlsx");
		for (int i=1;i<5; i++)
		{
			int randNum = (int) (Math.random() * 10);
			String userinfo[] = rd_excel.getUserInfo(1, i);
			Register_page.register_user(userinfo[0]+randNum,userinfo[1],userinfo[2],userinfo[3]); 
			driver.navigate().to("http://platform92.me/register");
		}
		driver.quit();
	}
	@Test(groups= "UserTest", priority = 4)
	public void checkUserDatabase() throws SQLException
	{
		PlatformDataBaseTest TestDB = new PlatformDataBaseTest();
		ResultSet rs = TestDB.UserDataBase("Select UserId, Username, email, IsDeleted from dbo.Users;");
		while (rs.next())
		{
			System.out.println(rs.getString(1)+ " " + rs.getString(2)+" " + rs.getString(3)+" "+ rs.getString(4));
		}
		if(rs!= null) try {rs.close();} catch(Exception e) {}
	}
}
