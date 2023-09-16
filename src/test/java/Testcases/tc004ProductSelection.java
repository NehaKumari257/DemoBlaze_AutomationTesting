package Testcases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.LoginPage;
import Pages.ProductSelectionPage;

public class tc004ProductSelection extends BaseClass {
	@Test
	public void productSelection() throws Exception {
		LoginPage lp=new LoginPage();
		lp.Clicklogin();
		lp.login("royneha257", "Nehakumari@12345");
		ProductSelectionPage sp=new ProductSelectionPage();
		sp.clickProduct();
	}
	
     
}
