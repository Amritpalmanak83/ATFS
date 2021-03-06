package PlatformHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass 
{
	static WebDriver driver;	
	// help to start Browser in BrowserFactory
	public static WebDriver startBrowser(String browserName, String url) 
	{
		String driverPath ="C:\\Users\\amrit\\eclipse-workspace\\library\\";

		if(browserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.ie.driver", driverPath+"MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}

	public static void dragAndDrop ( WebDriver driver, WebElement srcelement , WebElement dstElemenet)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(srcelement, dstElemenet).perform();
	}

	public static void hoverover(WebDriver driver, WebElement hvrelement)
	{
		Actions action = new Actions(driver);
		action.moveToElement(hvrelement).perform();
	}

	public  static void hoverAndClick(WebDriver driver, WebElement elementtoHover, WebElement elementToClick)
	{
		Actions action = new Actions(driver);
		waitElementpresent(driver,elementToClick);
		action.moveToElement(elementtoHover).click(elementToClick).build().perform();
	}

	public static boolean waitElementpresent(WebDriver driver,WebElement by)
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element= wait.until(ExpectedConditions.visibilityOf((by)));		
		boolean status = element.isDisplayed();
		if (status)
		{
			return true;
		}
		else 
		{
			return false;
		}						
	}
	public static void scrollto ( WebDriver driver, WebElement srcelement)
	{
		Actions action = new Actions(driver);
		action.moveToElement(srcelement).perform();
	}


}
