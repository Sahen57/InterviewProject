package testCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pomClass.TestPage;
import utilities.BaseClass;

public class DemoTestCase extends BaseClass {
	@Test(priority = 1)
	public void positive_Tc_01() throws InterruptedException {
		TestPage tp = new TestPage(driver);
		tp.getsearchField().sendKeys("rilpivirine");
		tp.getpopUp().click();
		tp.getmedicName().click();
		String firstWindow = driver.getWindowHandle();
		tp.getcountrySelect().click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		for (String window : windows) {
			itr.next();
			driver.switchTo().window(window);
		}

		WebElement applicationDate = tp.getappDate();
		Assert.assertEquals("09.08.2002", applicationDate.getText());

		WebElement publicationDate = tp.getpublicDate();
		Assert.assertEquals("19.05.2004", publicationDate.getText());

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.numberOfWindowsToBe(2));
		driver.switchTo().window(firstWindow);
	}

	@Test(priority = 2)
	public void negative_Tc_01() {
		TestPage tp = new TestPage(driver);
		tp.getsearchField().clear();
		tp.getsearchField().sendKeys("ripi");
		WebElement webtext = tp.getnotfound();
		Assert.assertEquals(" No result found with these search filters.", webtext.getText());

	}

}
