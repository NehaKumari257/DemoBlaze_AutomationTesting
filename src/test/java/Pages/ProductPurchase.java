package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass;

public class ProductPurchase extends BaseClass {
	
	@FindBy(xpath="//a[contains(text(),'Laptops')]")
	WebElement laptops;
	
	@FindBy(xpath="//a[contains(text(),'MacBook air')]")
	WebElement clickMacBook;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement addCart;
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement clickOnCart;
	
	@FindBy(xpath="//*[contains(text(),'Place Order')]")
	WebElement placeOrder;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement cardNo;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchase;
	
	@FindBy(xpath="//*[contains(text(),'Thank you for your purchase!')]")
	WebElement displayMsg;
	
	@FindBy(xpath="//*[contains(text(),'OK')]")
	WebElement clickOK;
	
	public ProductPurchase() {
		
		PageFactory.initElements(driver,this );
		
	}
	public void productOrder() throws Exception {
		clickElement(laptops);
		clickElement(clickMacBook);
		clickElement(addCart);
		Thread.sleep(5000);
	    driver.switchTo().alert().accept();
		clickElement(clickOnCart);
		clickElement(placeOrder);
		
	}
	public void fillDetails(String Name, String Country, String City, String Card, String Month, String Year) throws Exception {
		this.name.sendKeys(Name);
		this.country.sendKeys(Country);
		this.city.sendKeys(City);
		this.cardNo.sendKeys(Card);
		this.month.sendKeys(Month);
		this.year.sendKeys(Year);
		Thread.sleep(5000);
		clickElement(purchase);
		Thread.sleep(5000);
		Assert.assertTrue(validateElement(displayMsg));
		clickElement(clickOK);
		
		
		
	}
	

}
