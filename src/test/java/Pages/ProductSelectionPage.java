package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass;

public class ProductSelectionPage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Phones')]")
	WebElement mobile;
	
	@FindBy(xpath="//a[contains(text(),'Sony xperia z5')]")
	WebElement clickSony;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement addCart;
	
	@FindBy(xpath="//a[@id='cartur']")
	WebElement goTocart;
	
	@FindBy(xpath="//*[contains(text(),'Sony xperia z5')]")
	WebElement productName;
	
	public ProductSelectionPage() {
		PageFactory.initElements(driver,this );
		
	}
	public void clickProduct() throws Exception {
		clickElement(mobile);
		clickElement(clickSony);
		clickElement(addCart);
		Thread.sleep(5000);
	    driver.switchTo().alert().accept();
	    clickElement(goTocart);
	    Assert.assertTrue(validateElement(productName));
		
	}

}
