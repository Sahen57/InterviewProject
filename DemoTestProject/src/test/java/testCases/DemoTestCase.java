package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pomClass.TestPage;
import utilities.BaseClass;

public class DemoTestCase extends BaseClass {
	@Test(priority=1)
	public void positive_Tc_01() {
		TestPage tp = new TestPage(driver);
		tp.getsearchField().sendKeys("rilpivirine");
		tp.getpopUp().click();
		tp.getmedicName().click();
		WebElement text = tp.getdetailsText();
		System.out.println(text.getText());
		tp.getcountrySelect().click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		for (String window : windows) {
			itr.next();
			driver.switchTo().window(window);
		}
		System.out.println(driver.getCurrentUrl());

		WebElement applicationDate = tp.getappDate();
		System.out.println(applicationDate.getText());
		Assert.assertEquals("09.08.2002", applicationDate.getText());

		WebElement publicationDate = tp.getpublicDate();
		System.out.println(publicationDate.getText());
		Assert.assertEquals("19.05.2004", publicationDate.getText());
	}

	@Test(priority=2)
	public void negative_Tc_01() {
		TestPage tp = new TestPage(driver);
		tp.getsearchField().sendKeys("ripi");
	}

}
