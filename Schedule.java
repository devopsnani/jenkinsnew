package package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Schedule {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		// System.setProperty("webdriver.firefox.marionette","G:\\Selenium\\geckodriver-v0.22.0-arm7hf.exe");
		// driver=new FirefoxDriver();
		// DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		String url = "https://maithali.jhamvar:Rdi@1235@tac.rdisoftware.com/";
		driver.get(url);
		Thread.sleep(9000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		// driver.manage().window().maximize();
		driver.findElement(By.id("userNameTBox")).sendKeys("nithin.uppalapati");
		driver.findElement(By.id("psswdTBox")).sendKeys("1234");
		driver.findElement(By.id("loginPerform")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("reportsMenuID")));
		driver.findElement(By.id("reportsMenuID")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("filterButtonId")));
		driver.findElement(By.xpath("//*[@id='buildLabelId']/input")).clear();
		driver.findElement(By.xpath("//*[@id='buildLabelId']/input")).sendKeys("SP9MR4QR0B57_new _15Oct");
		driver.findElement(By.id("filterButtonId")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td[1]/button")));
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td[1]/button")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='tableReports']/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[9]/a")));
		String status = driver
				.findElement(By.xpath("//*[@id='tableReports']/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[7]")).getText();
		System.out.println(status);
		if (status.equals("Failed") || status.equals("Passed") || status.equals("Aborte")
				|| status.equals("Not Executed")) {
			driver.findElement(By.xpath("//*[@id='tableReports']/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[9]/a")).click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='executionDetails']/tbody/tr/td[2]/label[1]")));
			List<WebElement> li = driver.findElements(By.xpath("//*[@id='executionDetails']/tbody/tr/td[2]/label"));
			int size = li.size();
			for (int i = 1; i <= size; i++) {
				WebElement c = driver
						.findElement(By.xpath("//*[@id='executionDetails']/tbody/tr/td[2]/label[" + i + "]"));
				try {

					c.click();
					Thread.sleep(4000);
					driver.findElement(By.xpath("//*[@id='viewLog']/div/div/div[2]/div/div/button[2]")).click();
					Thread.sleep(4000);
				} catch (Exception e) {
					String tc = c.getText();
					System.out.println("The test case :" + " " + tc + " " + "is blocked");
					WebElement s = driver.findElement(By.xpath("//*[@id='executionDetails']/tbody/tr/td[1]"));
					String ts = s.getText();
					System.out.println("The test case related to the blocked test case is" + " " + ts);

				}
			}
		}
		else{
			System.out.println("running");
		}

	}
}
