package PlatformTesting.com.platform.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginRegistrationClass 
{
	WebDriver driver;

	@FindBy(id="dnn_dnnLogin_enhancedLoginLink")
	WebElement Loginlink;

	@FindBy(how=How.ID,using="dnn_ctr_Login_Login_DNN_txtUsername")	
	WebElement username;

	@FindBy(how=How.ID,using="dnn_ctr_Login_Login_DNN_txtPassword")
	WebElement password;

	@FindBy(how=How.ID,using="dnn_ctr_Login_Login_DNN_cmdLogin")
	WebElement loginbutton;

	@FindBy(how=How.XPATH,using="//div[@id='dnn_ctr_Register_userForm']/div[1]/input")
	WebElement usernameinput;

	@FindBy(how=How.XPATH,using="//div[@id='dnn_ctr_Register_userForm']/div/div[2]/input")
	WebElement passinput;	

	@FindBy(how=How.XPATH,using="//div[@id='dnn_ctr_Register_userForm']/div[3]/input")
	WebElement confpassinput;

	@FindBy(how=How.XPATH,using="//div[@id='dnn_ctr_Register_userForm']/div[4]/input")
	WebElement userDisplayinput;	

	@FindBy(how=How.XPATH,using="//div[@id='dnn_ctr_Register_userForm']/div[5]/input")
	WebElement userEmailinput;

	@FindBy(how=How.ID,using="dnn_dnnUser_enhancedRegisterLink")
	WebElement Registerlink;	
	
	@FindBy(how=How.ID,using="dnn_ctr_Register_registerButton")
	WebElement Registerbutton;

	
	
	public LoginRegistrationClass(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void login_engage(WebDriver driver, String user, String pass)
	{
		Loginlink.click();
		driver.switchTo().frame("iPopUp");
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbutton.click();
		driver.switchTo().defaultContent();

	}
	public void register_user(String user_name, String pass_word, String display_name , String email )
	{
		Registerlink.click();
		driver.switchTo().frame("iPopUp");
		usernameinput.sendKeys(user_name);
		passinput.sendKeys(pass_word);
		confpassinput.sendKeys(pass_word);
		userDisplayinput.sendKeys(display_name);
		userEmailinput.sendKeys(email);
		Registerbutton.click();
		driver.switchTo().defaultContent();
	}
}
