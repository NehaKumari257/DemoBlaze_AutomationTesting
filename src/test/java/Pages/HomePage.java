package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage () {
		PageFactory.initElements(driver,this );
		
	}
	
	public void pageload() {                                //  verify that page is loaded successfully
		JavascriptExecutor j = (JavascriptExecutor)driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")){
		   System.out.println("Page has loaded Successfully");
		}
	}
	
}
