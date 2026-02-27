package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

public static WebDriver driver;
public  Logger logger;
public Properties p;

	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser",})
	public void setUp(String os,String br) throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	    p = new Properties();
	    p.load(file); // load the file 
		
        logger = LogManager.getLogger(this.getClass());
        
        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
        	DesiredCapabilities capabilities = new DesiredCapabilities();
        	
        	// os
        	switch(os)
        	{
        	  case "windows": capabilities.setPlatform(Platform.WIN11);break;
        	  case "Mac": capabilities.setPlatform(Platform.MAC);break;
        	  case "Linux":capabilities.setPlatform(Platform.LINUX);break;
        	  default:System.out.print("No Matching operating System");return;
        	}
        	
        	// browser
        	switch(br.toLowerCase())
        	{
        	 case "chrome":capabilities.setBrowserName("chrome");break;
        	 case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
        	 default:System.out.print("invalid browser name");return;
        
        	}
        	
        	driver = new RemoteWebDriver(new URL("http://192.168.31.240:4444/wd/hub"),capabilities);
        	
        }
        if(p.getProperty("execution_env").equalsIgnoreCase("local"))  /// we can put else as well
        {
        	switch(br.toLowerCase())
    		{
    	        case "chrome":driver = new ChromeDriver();break;
    	        case "edge":driver = new EdgeDriver();break;
    	        case "firefox":driver = new FirefoxDriver();break;
    	        default:System.out.print("invalid browser Name"); return; // why we used return here coz if browser is invalid rest of the statement won't execute
    		}
        }
        

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));  // reading url from properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public  String randomNames()
    {
       String generaterandomName = RandomStringUtils.randomAlphabetic(6);
	   return generaterandomName;
    }


	public String randomNumber()
	{
		String generaterandomNumber = RandomStringUtils.randomNumeric(10);
	    return generaterandomNumber;
	}
	
    public String randomPassword()
    {
    	 String generaterandomName = RandomStringUtils.randomAlphabetic(6);
    	 String generaterandomNumber = RandomStringUtils.randomNumeric(10);
    	 
		     return (generaterandomName+"@"+generaterandomNumber);
    }
    
    public String randomEmail()
    {
    	String generaterandomEmail =  RandomStringUtils.randomAlphabetic(5).toLowerCase()
                + RandomStringUtils.randomNumeric(3)
                + "@gmail.com";
    	return generaterandomEmail;
    }
	
	
    public String captureScreen(String tname)
    {
    	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	
    	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    	
    	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png"; 
        
    	File targetFile = new File(targetFilePath);
    	
    	sourceFile.renameTo(targetFile);
    	
    	
    	return targetFilePath;
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
}
