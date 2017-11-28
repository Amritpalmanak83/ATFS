package PlatformTesting.com.platform.org;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PlatformDataBaseTesting.PlatformDataBaseTest;
import PlatformHelper.HelperClass;
import PlatformTestDataSheet.ExcelDataSheet;

public class VerifyLoginTest 
{
	public WebDriver driver;
	@Test(groups= "UserTest")
	public void checkvalidUser() 
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/login");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		login_page.login_engage("Host","dnnhost"); 
	}
	@Test(groups= "UserTest")
	public void checkvalidLogin()
	{
		driver = HelperClass.startBrowser("Chrome", "http://platform92.me/login");
		driver.manage().window().maximize();
		LoginRegistrationClass login_page = PageFactory.initElements(driver, LoginRegistrationClass.class);
		ExcelDataSheet excel = new ExcelDataSheet("C:\\Users\\Amrit\\Documents\\ATFS\\com.platform.org\\Data\\TestDataSheet.xlsx");
		String userinfo[] = excel.getUserData(0, 0);
		login_page.login_engage(userinfo[0],userinfo[1]); 
		driver.quit();
	}
	@Test(groups= "UserTest")
	public void registerUser()
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
		driver.quit();
	}
	@Test(groups= "UserTest")
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
