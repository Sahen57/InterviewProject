package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.out.println("----Launching Browser-------");
		driver = new ChromeDriver();
		driver.get("https://www.wipo.int/patinformed/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("-----closing Browser-------");
		driver.quit();

	}

}
