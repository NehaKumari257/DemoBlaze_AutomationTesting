package Testcases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.HomePage;
import Utility.Utils;

public class tc001HomePage extends BaseClass{
	@Test
	public void launch() throws Exception {                //After lauching the browser find that page is nevigated.
		Utils ut=new Utils();
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		HomePage hp=new HomePage();
		hp.pageload();
		
	}
	
	

}
