package package1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Compare {
	static WebDriver driver=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.firefox.marionette","G:\\Selenium\\geckodriver-v0.22.0-arm7hf.exe");
		driver=new FirefoxDriver();
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		
		String url="https://demo.opencart.com/";
		driver.get(url);
		//driver.manage().window().maximize();
		Thread.sleep(5000);
		BufferedImage expectedImage = ImageIO.read(new File("D://nena//job//IMG_2004.JPG"));
		BufferedImage actualImage = ImageIO.read(new File("D://nena//job//IMG_2004-Copy.JPG"));
		ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if(diff.hasDiff()==true)
        {
         System.out.println("Images are Not Same");
        }
        else {
         System.out.println("Images are Same");
        }
	}

}
