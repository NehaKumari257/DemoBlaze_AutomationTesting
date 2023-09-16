package Testcases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.LoginPage;
import Pages.LogoutPage;

public class tc006Logout extends BaseClass {
	@Test
	public void logout() {
		LoginPage lp=new LoginPage();
		lp.Clicklogin();
		lp.login("royneha257", "Nehakumari@12345");
		LogoutPage pl=new LogoutPage();
		pl.clickOnlogout();
	}
 
}
