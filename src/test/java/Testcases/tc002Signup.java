package Testcases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.SignupPage;

public class tc002Signup extends BaseClass{
	
	@Test
	public void signUp() {
	
		SignupPage sp=new SignupPage();
		sp.clickSignup();
		sp.signup("royneha257","Nehakumari@12345");
		
	}

}
