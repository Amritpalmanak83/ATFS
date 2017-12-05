package Library;

import java.io.File;
import java.io.IOException;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility 
{
	@SuppressWarnings("deprecation")
	public static void captureScreenshot( WebDriver driver, String TestName)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.newFileUtils().copyFile(source, new File("./Screenshots/"+TestName+".png"));
			
			System.out.println("Screenshot captured");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 
