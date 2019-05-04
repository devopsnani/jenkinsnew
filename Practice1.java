package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice1 {
	static WebDriver driver=null;
	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.firefox.marionette","G:\\Selenium\\geckodriver-v0.22.0-arm7hf.exe");
		driver=new FirefoxDriver();
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		
		String url="https://demo.opencart.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		System.out.println("Registration  page opened successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean t=driver.getPageSource().contains("nithi");
		System.out.println(t);
		driver.findElement(By.name("firstname")).sendKeys("nithin");
		driver.findElement(By.name("lastname")).sendKeys("chowdary");
		String email="nithinu14@gmail.com";
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("telephone")).sendKeys("9110353315");
		RemoteWebDriver rwb=(RemoteWebDriver)driver;
		String c="window.scrollTo(0,document.body.scrollHeight)";
		rwb.executeScript(c);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String password="Naniu1995";
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys("Naniu1995");
		driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/label[1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		String text=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		if(text.equals("Your Account Has Been Created!")){
			System.out.println("Account has created for the user having");
			System.out.println("UserNmae"+" "+email);
			System.out.println("Password"+" "+password);
		}
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		System.out.println("Account logged out successfully");
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	}

}
