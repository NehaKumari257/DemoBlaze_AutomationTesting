package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class SignupPage extends BaseClass {
	
	
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	WebElement Signup;
	
	@FindBy(xpath="//input[@id='sign-username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='sign-password']")
	WebElement password;
	
	@FindBy(xpath="(//*[contains(text(),'Sign up')])[2]")
	WebElement submit;
	
	public SignupPage() {
		PageFactory.initElements(driver,this );
		
	}
	public void clickSignup() {
		clickElement(Signup);
		
	}
	public void signup(String name, String pswd) {
		this.username.sendKeys(name);	
		this.password.sendKeys(pswd);
		clickElement(submit);
	}
	
	
	
}
