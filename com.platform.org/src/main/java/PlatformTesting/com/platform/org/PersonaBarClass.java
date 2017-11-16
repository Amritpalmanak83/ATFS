package PlatformTesting.com.platform.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import PlatformHelper.HelperClass;

public class PersonaBarClass 
{
	WebDriver driver;

	@FindBy(how=How.XPATH,using="//div[@id='personabar']")
	WebElement personabar1;
	
	@FindBy(how=How.XPATH,using="//*[@id='Settings']")
	WebElement Setting;
	
	@FindBy(how=How.XPATH,using = ".//*[@id='Evoq.StructuredContent']")
	WebElement StructureContent;

	public void PersonabarOpenContent(WebDriver driver) 
	{
		driver.switchTo().frame("personaBar-iframe");
		if(HelperClass.waitElementpresent(driver, personabar1)) 
		{
			HelperClass.hoverover(driver, Setting);
			HelperClass.hoverAndClick(driver, Setting, Setting);
		}
		else
		{
			System.out.println("Element is not found ");
		}

	}
}
