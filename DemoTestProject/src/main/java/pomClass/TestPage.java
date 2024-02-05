package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {
	public WebDriver driver;

	public TestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='searchField']")
	private WebElement searchField;

	public WebElement getsearchField() {
		return searchField;
	}

	@FindBy(xpath = "//button[text()='I have read and agree to the terms']")
	private WebElement popUp;

	public WebElement getpopUp() {
		return popUp;
	}

	@FindBy(xpath = "//div[text()='HIV INHIBITING PYRIMIDINES DERIVATIVES (38)']")
	private WebElement medicName;

	public WebElement getmedicName() {
		return medicName;
	}

	@FindBy(xpath = "//table[@class='patentDetails noBorder']//td[contains(text(),'Switzerland')]/../../..//a")
	private WebElement countrySelect;

	public WebElement getcountrySelect() {
		return countrySelect;
	}

	@FindBy(xpath = "//span[text()='Application Date']/parent::span/following-sibling::span")
	private WebElement appDate;

	public WebElement getappDate() {
		return appDate;
	}

	@FindBy(xpath = "//span[text()='Publication Date']/parent::span/following-sibling::span")
	private WebElement publicDate;

	public WebElement getpublicDate() {
		return publicDate;
	}
	
	@FindBy(xpath="//div[@class='card noResult flex center-v']//span")
	private WebElement notfound;
	
	public WebElement getnotfound()
	{
		return notfound;
	}

}
