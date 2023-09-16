package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(xpath="(//*[contains(text(),'Log in')])[3]")
	WebElement clickLogin;
	
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement loginUsername;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement loginPswd;
	
	@FindBy(xpath="(//*[contains(text(),'Log in')])[2]")
	WebElement login;
	
	@FindBy(xpath="//a[@id='nameofuser']")
	WebElement ele1; 
	
	public LoginPage() {
		PageFactory.initElements(driver,this );
		
	}
	
	public void Clicklogin() {
		clickLogin.click();
	}
	
	public void login(String uname, String pswd) {    //Login with positive test data
		
		this.loginUsername.sendKeys(uname);
		this.loginPswd.sendKeys(pswd);
		clickElement(login);
		waitForElement(ele1, 10);
		//driver.switchTo().
		try {
		String expected1="Welcome royneha257";
	    Assert.assertEquals(expected1,ele1.getText());
	}
		catch(Exception ex) {
			System.out.println("Problem while logging into demoblaze website");
		}
		
	}
	
     public void login_negative(String uname1, String pswd1) throws Exception {    //Login with negative test data
		
		this.loginUsername.sendKeys(uname1);
		this.loginPswd.sendKeys(pswd1);
		clickElement(login);
		//waitForElement(ele1, 10);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	
     }
	
	public WebElement validate_user() {
		return ele1;
		
	}
	

}
