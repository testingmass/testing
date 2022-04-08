package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base1;
import utilities.ReadXLSdata;
import utilities.read;

public class TC2 extends base1 {
	@Test(dataProviderClass = read.class, dataProvider ="ecelfile")
	
	public static void TC1(String username, String password) 
	{
		driver.findElement(By.xpath(loc.getProperty("signin"))).click();
		driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("nextbutton"))).click();
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login"))).click();
	
}
	

	/*@DataProvider(name = "testdata")
	public Object[][] tdata(){
		return new Object[][] {
			{"tmasters27@gmail.com","Mahi53@"},
			{"tmasters27@gmail.com","Mahi57@"},
			{"tmasters22@gmail.com","Mahi37@"},
			{"tmasters227@gmail.com","Mahi537@"}
		};*/
	
		
		
	

	
	

}
