package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base1 {


	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	@BeforeMethod
	public void setup() throws IOException {
		
		if (driver == null) {
			
		
			
			//System.out.println("the path is:" +System.getProperty("user.dir"));
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config properties");
			FileReader fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		
			WebDriverManager.chromedriver().setup();//base
			base1.driver = new ChromeDriver();//base
			driver.get(prop.getProperty("testurl"));  //properties
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
		
			WebDriverManager.firefoxdriver().setup();//base
			base1.driver = new FirefoxDriver();//base
			driver.get(prop.getProperty("testurl"));  //properties
			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();//base
			base1.driver  = new EdgeDriver();//base
			driver.get(prop.getProperty("testurl"));   //properties
			
		}
		
	}
	
	@AfterMethod

	public void teardown() {
      driver.close();
		System.out.println("Teardown is sucessful");
		
	}
	
	
}
