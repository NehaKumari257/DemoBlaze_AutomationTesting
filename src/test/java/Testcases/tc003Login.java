package Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.LoginPage;

public class tc003Login extends BaseClass  {
	
	@BeforeTest
	public void declareSheetName() {
		sheetName="positiveTestData";
	}
	
	@Test(dataProvider="getExcelData")
	public void loginTest(String uname, String password) {
		LoginPage lp=new LoginPage();
		lp.Clicklogin();
		lp.login(uname,password);	
	    Assert.assertTrue(validateElement(lp.validate_user()));
			
	}
    @BeforeTest
	public void declareSheetName2() {
		sheetName="negativeTestData";
	}
	
	@Test(dataProvider="getExcelData")
	public void loginTest2(String uname, String password) throws Exception {
		LoginPage lp=new LoginPage();
		lp.Clicklogin();
		lp.login_negative(uname, password);	

	}
	
}
