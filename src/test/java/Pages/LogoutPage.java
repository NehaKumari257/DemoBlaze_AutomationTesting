package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class LogoutPage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnlogout() {
		clickElement(logout);
	}
	

}
