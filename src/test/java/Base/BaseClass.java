package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.util.TimeUtils;

public class BaseClass {
	//Browser Info WebDriver driver = new ChromeDriver();
	//Url info
	//Username and password
    public static Properties prop = new Properties();
    public static WebDriver driver;
    //Step 1
    public BaseClass() {
    	try {
    	
    	FileInputStream file = new FileInputStream("C:\\Users\\ravik\\Desktop\\Testing\\AutomationTesting\\src\\test\\java\\EnvironmentSetup\\Config.properties");
    	 prop.load(file);
    	}
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(IOException a) {
    		a.printStackTrace();
    	}
    }
    //Step 2
    public static void initiation() {
    	//driver path 
    	//maximise, pageload, implicit , getting url
    	//if browser = chrome  webdriver.chrome.driver
    	//else if browser = Firefox webdriver.gecko.driver
    	String browsername = prop.getProperty("browser");
    	if(browsername.equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    		else if(browsername.equals("Firefox")) {
    		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");	
    		driver = new FirefoxDriver();  	    		
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(Utility.TimeUtils.pagetime, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    }
    public static void screenshots(String filename) {
    	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    		FileUtils.copyFile(file,new File("C:\\Users\\ravik\\Desktop\\Testing\\AutomationTesting\\src\\test\\java\\screenshot\\Screenshots" + filename + ".jpg"));
    	}
    	catch(IOException a) {
    		a.printStackTrace();
    	}
    }
}
